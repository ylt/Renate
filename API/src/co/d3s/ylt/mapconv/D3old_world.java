package co.d3s.ylt.mapconv;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

public class D3old_world extends WorldData {
	public D3old_world() {

	}

	public void load(File file) throws IOException {
		DataInputStream input = new DataInputStream(new GZIPInputStream(
				new FileInputStream(file)));
		byte[] data = new byte[0];
		input.readFully(data);
		ByteBuffer buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.LITTLE_ENDIAN);

		int version = buffer.getInt();

		Size_X = buffer.getShort();
		Size_Z = buffer.getShort();
		Size_Y = buffer.getShort();
		int Map_Size = Size_X * Size_Y * Size_Z;

		if (version >= 1020) { // spawn coordinates introduced.
			Spawn_X = buffer.getShort();
			Spawn_Z = buffer.getShort();
			Spawn_Y = buffer.getShort();

			if (version >= 1030) { // spawn rotation introduced.
				Spawn_Rot = buffer.getShort();
				Spawn_Look = buffer.getShort();
			}
		}

		if (version <= 1040) {
			buffer.get(blocks, 0, Map_Size);

			if (version >= 1010) {
				byte rank[] = new byte[0];
				buffer.get(rank, 0, Map_Size);
			}
			if (version == 1040) {
				char playerdata[] = new char[0];
				// buffer.asCharBuffer().get(playerdata, 0, Map_Size);
				for (int x = 0; x < Map_Size; x++) {
					playerdata[x] = buffer.getChar();
					buffer.getChar(); // no increment function..
				}
			}
		} else { // fucking inefficient, wtf was Dadido3 thinking?
			byte rank[] = new byte[0];
			char playerdata[] = new char[0];
			for (int x = 0; x < Map_Size; x++) {
				blocks[x] = buffer.get();
				rank[x] = buffer.get();
				playerdata[x] = buffer.getChar();
			}
		}

	}

	public void save() {
		// TODO: add save
	}
}
