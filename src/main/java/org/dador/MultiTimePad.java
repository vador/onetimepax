package org.dador;

//Mohammed BELAFDAL
//Islam AMAR ROUANA

/**
 *
 */
public class MultiTimePad {

	/**
	 * Main function. Loads cryptogram and displays decryption
	 *
	 * @param args No arguments are processed
	 */
	public static void main(final String[] args) {
		String index = "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E";

		String msg0 = "ce38a99f9c89fc89e8c5c14190f7fe3f0de5c388e3670420c57db02e66ee51";
		String msg1 = "d43fb89f9092ebdbeecad10494bbf6220deed5dce36d0620c270b23223d351";
		String msg2 = "d370add2df8ce29ae3c5dc0f87bbfe715ee9d3daf27c546ddf6ba0356cf451";
		String msg3 = "d235ecd68cdcfa93e88bda0f8ce2bf2148fec3c7f928006f966ca12970ee51";
		String msg4 = "cd38a9d1df8fe694f8c7d14197febf3c48e9c488e3675464d938a7346ae940";
		String msg5 = "d370b8d79692e5dbf9c3d018c0e8f73e58e0d488f167186cd96ff3346af751";
		String msg6 = "ce38a5ccdf95fddbfddec70492bbeb394ce290dcff690020d976b67c6ae951";
		String[] messages = new String[] { msg0, msg1, msg2, msg3, msg4, msg5, msg6 };
		int nbMsg = messages.length;
		byte[][] byteArrayMsg = new byte[nbMsg][];
		byte[][] byteArrayXor = new byte[nbMsg][];

		byte[] key;
		byte[] tmpByteMsg;
		int i;

		String displayIndex = HexConverters.toPrintableHexFromByteArray(HexConverters.toByteArrayFromHex(index));
		System.out.println("Original Cryptograms :");
		System.out.print("i: ");
		System.out.println(displayIndex);

		// Transforme les messages sous un format "tableau d'octets" pour pouvoir les
		// manipuler
		for (i = 0; i < nbMsg; i++) {
			tmpByteMsg = HexConverters.toByteArrayFromHex(messages[i]);
			byteArrayMsg[i] = tmpByteMsg;
			System.out.print(i);
			System.out.print(": ");
			System.out.println(HexConverters.toPrintableHexFromByteArray(byteArrayMsg[i]));
		}

		System.out.println();

		key = new byte[msg1.length() / 2];
		// TODO: renseigner les valeurs de la clé..
		key[0] = (byte) ((byte) 'T' ^ 0xce);
		key[1] = 0x50;
		// key[14] = (byte) 0x9b;
		key[0x09] = (byte) 0xab;
		key[0x04] = (byte) 0xff;
		key[0x03] = (byte) 0xbf;
		key[0x02] = (byte) 0xcc;
		key[0x0b] = (byte) 0x61;
		key[0x05] = (byte) 0xfc;
		key[0x06] = (byte) ((byte) 'k' ^ 0xe5);
		key[0x07] = (byte) ((byte) 'o' ^ 0x94);
		key[0x08] = (byte) ((byte) 'u' ^ 0xf8);
		key[0x09] = (byte) (0x8b ^ 0x20);
		key[0x0a] = (byte) ((byte) 'd' ^ 0xd1);
		key[0x0b] = (byte) (0x41 ^ 0x20);
		key[0x0c] = (byte) (0xc0 ^ 0x20);
		key[0x0d] = (byte) (0xbb ^ 0x20);
		key[0x0e] = (byte) (0xbf ^ 0x20);
		key[0x0f] = (byte) (0x71 ^ 0x20);
		key[0x10] = (byte) (0x0d ^ 0x20);
		key[0x11] = (byte) ((byte) 'i' ^ 0xe5);
		key[0x12] = (byte) ((byte) 's' ^ 0xc3);
		key[0x13] = (byte) (0x88 ^ 0x20);
		key[0x14] = (byte) ('e' ^ 0xf2);
		key[0x15] = (byte) (0x69 ^ 'a');
		key[0x16] = (byte) (0x54 ^ 0x20);
		key[0x17] = (byte) (0x20 ^ 0x20);
		key[0x18] = (byte) (0x96 ^ 0x20);
		key[0x19] = (byte) (0x38 ^ 0x20);
		key[0x1a] = (byte) (0x20 ^ 0xf3);
		key[0x1b] = (byte) (0x20 ^ 0x7c);
		key[0x1c] = (byte) ('e' ^ 0x66);
		key[0x1d] = (byte) ('t' ^ 0xee);
		key[0x1e] = (byte) ('.' ^ 0x51);

		System.out.println("Key :");
		System.out.println(displayIndex);
		System.out.println(HexConverters.toPrintableHexFromByteArray(key));

		// Affichage des XOR :
		System.out.println();
		System.out.println("XOR messages :");
		System.out.print("i: ");
		System.out.println(displayIndex);
		i = 1;
		while (i < nbMsg) {
			tmpByteMsg = HexConverters.toByteArrayFromHex(messages[i]);
			byteArrayXor[i] = HexConverters.xorArray(tmpByteMsg, HexConverters.toByteArrayFromHex(messages[0]));
			tmpByteMsg = byteArrayXor[i];
			System.out.print(i);
			System.out.print(": ");
			System.out.println(HexConverters.toPrintableHexFromByteArray(tmpByteMsg));

			i++;
		}

		// Affichage des messages décodés System.out.println();
		System.out.println("Decoded messages :");
		i = 0;
		while (i < nbMsg) {
			tmpByteMsg = HexConverters.toByteArrayFromHex(messages[i]);
			byteArrayXor[i] = HexConverters.xorArray(key, HexConverters.toByteArrayFromHex(messages[i]));
			tmpByteMsg = byteArrayXor[i];
			System.out.print(i);
			System.out.print(": ");
			System.out.println(HexConverters.toPrintableString(tmpByteMsg));
			i++;
		}
//		 
	}
}
