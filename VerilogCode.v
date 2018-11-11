module Square_Rooter(input clk, input[7:0] num, output[15:0] res, output[7:0] buffer_out);
reg[15:0] res;
reg[7:0] buffer_out;
reg[15:0] val;
reg[7:0] bitIndex;
reg[7:0] i; 
reg[7:0] buffer;

always @(posedge clk) begin
	res = 0;
	bitIndex = 14;
	i = 0;
	buffer = 4;
	val = num << 8;
		
	while(!((((val >>> 15) & 1) | ((val >>> 14) & 1)) == 1)) begin
		val = val << 2;
		buffer = buffer + 1;
	end
	
	while(i < 8)begin
		if(!(val < res + ( 1 << bitIndex))) begin
			val = (val + ~(res+(1<<bitIndex))+1);
			res = res + (1 << (bitIndex + 1));
		end
		res = res >>> 1;
		bitIndex = (bitIndex + ~2 + 1);
		i = i + 1;
	end
	
	buffer_out = buffer;
end

endmodule

module Test_Bench;
	reg[7:0] i;
	reg clk;
	reg [7:0]num = 0;
	wire[15:0] res;
	wire[7:0] buffer_out;

	Square_Rooter sqrt(clk,num,res, buffer_out);

	initial begin
		forever begin
			#5 clk = 0; num = num+1;
			#5 clk = 1;
			#5 $display("Square Root of %d with a buffer of %d:\n%b\n",num,buffer_out,res);
		end	
	end
	
	//This program will run from num = 1 to num = 255
	initial begin
		#3825
		$finish;
	end
endmodule