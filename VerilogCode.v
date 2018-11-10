module Square_Rooter(input clk, input[7:0] num, output[15:0] res);
reg[15:0] res = 0;
reg[15:0] val;
reg[7:0] bitIndex = 14;
reg[7:0] i = 0; 
reg[7:0] buffer = 4; 
always @(posedge clk) begin
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
end

endmodule

module Test_Bench;
	reg[7:0] i;
	reg clk;
	reg[7:0] num = 49;
	wire[15:0] res;

	Square_Rooter sqrt(clk,num,res);

	initial begin		
		#5	clk = 0;
		#5	clk = 1;
		#5 $display("%b",res);
	end
endmodule