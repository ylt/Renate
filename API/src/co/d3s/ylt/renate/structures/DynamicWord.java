package co.d3s.ylt.renate.structures;

import java.nio.CharBuffer;
import java.text.DecimalFormat;

//cpu inefficient, memory efficient array,
// - only wastage is remainder of last byte
public class DynamicWord {
	public byte[] bytes;
	private int wordsize=4;
	private int length;
	public DynamicWord(int length) {
		bytes = new byte[(int) Math.ceil(length*wordsize/8)+1];
		this.length = length;
	}
	public int get(int pos) {
		return get(bytes, wordsize, pos);
	}
	public static int get(byte[] bytes, int wordsize, int pos) {
		int bitoffset = wordsize*pos;
		int byteoffset = bitoffset/8;
		int insidebits = bitoffset % 8;
		
		//we calculate the start of data, get the byte offset by dividing by 8
		// the remainder is the bits until start of data.
		//in order to extract data we'll need to shift insidebits+wordsize right
		// so that it's in least significant bit position, before we can then apply
		// an AND.
		int bval = bytes[byteoffset];
		int over = 8;
		if (insidebits+wordsize > 8) {
			int bitsover = 8-(insidebits+wordsize);
			bval = bval<<8 + bytes[byteoffset];
			over=16;
		}
		//align it to right.
		bval = bval >> over-(insidebits+wordsize);
		bval = bval & (int)Math.pow(2,wordsize-1);
		
		return bval;
	}
	public void set(int pos, int value) {
		//System.out.println("elements: "+bytes.length+", wordsize: "+wordsize+", "+pos+" -> "+(wordsize*pos)/8);
		//if (Math.log(value)/Math.log(2)) //probably slow
		if (value >= Math.pow(2,wordsize)) {
			int newsize = (int) Math.ceil(Math.log(value)/Math.log(2));
			System.out.println("Scaling from "+wordsize+" to "+newsize+" ("+value+">="+(Math.pow(2,wordsize))+")");
			byte[] bytes2 = new byte[(int) Math.ceil(length*newsize/8)+1];
			for(int i = 0; i < length; i++) {
				int val = get(i);
				set(bytes2, newsize, i, val);
			}
			bytes = bytes2;
			wordsize = newsize;
		}
		set(bytes, wordsize, pos, value);
	}
	public static void set(byte[] bytes, int wordsize, int pos, int value) {
		int bitoffset = wordsize*pos;
		int byteoffset = bitoffset/8;
		int insidebits = bitoffset % 8;
		//avoid accidentally overwriting
		// data after inserted value
		//value = value & (int)Math.pow(2,wordsize-1);

		int bval = bytes[byteoffset];
		int over = 8;
		if (insidebits+wordsize > 8) {
			int bitsover = 8-(insidebits+wordsize);
			bval = bval<<8 + bytes[byteoffset];
			over=16;
		}
		//remove old value
		int shift = over-(insidebits+wordsize);
		int mask = (int)Math.pow(2,wordsize-1)<<shift;
		
		bval = bval & ~mask; //subtract mask from value
		bval = bval | (value << shift); //OR in the new data
		if (over == 16) {
			bytes[byteoffset+1] = (byte)(bval&0xFF);
			bytes[byteoffset] = (byte)(bval>>8);
		}
		else {
			bytes[byteoffset] = (byte)bval;
		}
		System.out.println("setting "+value);
	}
	
	public void debug() {
		{
			StringBuffer outsb = new StringBuffer();
			for(int i = 0; i < bytes.length; i++) {
				outsb.append(Integer.toBinaryString(bytes[0]&0xFF));
			}
			CharBuffer outcb = CharBuffer.wrap(outsb.toString());
			StringBuffer out = new StringBuffer();
			while(outcb.hasRemaining()) {
				out.append(" ");
				for(int i = 0; i < wordsize; i++) {
					try {
						out.append(String.valueOf(outcb.get()));
					}
					catch (Exception e) {
						break;
					}
				}
			}
			System.out.println(out);
		}
		{
			StringBuffer outsb = new StringBuffer();
			for(int i = 0; i < length; i++) {
				outsb.append(" "+String.format("%"+wordsize+"s", Integer.toBinaryString(get(i))).replace(' ', '0'));
			}
			System.out.println(outsb.toString());
		}
	}
	
	//method simply used for testing
	public static void main(String[] args) {
		DynamicWord word = new DynamicWord(8);
		//word.set(0, 0);
		//System.out.println(word.get(0));
		
		for (int i = 0; i < 5; i++) {
			word.set(i, 2);
			System.out.println(word.get(i));
		}
		word.debug();
		
		//System.out.println(String.format("%8s", Integer.toBinaryString(word.bytes[0]&0xFF)).replace(' ', '0'));
	}
}
