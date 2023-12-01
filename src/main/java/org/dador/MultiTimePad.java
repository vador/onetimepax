package org.dador;

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
        String[] messages = new String[]{msg0, msg1, msg2, msg3, msg4, msg5, msg6};
        int nbMsg = messages.length;
        byte[][] byteArrayMsg = new byte[nbMsg][];

        byte[] key;
        byte[] tmpByteMsg;
        int i;


        String displayIndex = HexConverters.toPrintableHexFromByteArray(HexConverters.toByteArrayFromHex(index));
        System.out.println("Original Cryptograms :");
        System.out.print("i: ");
        System.out.println(displayIndex);

        // Transforme les messages sous un format "tableau d'octets" pour pouvoir les manipuler
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
        key[0] = (byte) (0xd3 ^ 0x49) ;
        key[1] = 0x50;
        key[2]= (byte) (0xec ^ 0x20);
        key[3]=(byte) (0x9f ^0x20);
        key[4]=(byte) (0xdf ^ 0x20);
        key[5]=(byte) (0xdc ^ 0x20);
        key[6]=(byte) (0xeb ^ 0x65);
        key[7]=(byte) (0xdb ^ 0x20);
        key[8]=(byte) (0xe8 ^ 0x65);
        key[9]=(byte) (0x8b ^ 0x20);
        key[10]=(byte) (0xc1 ^ 0x74);
        key[11]=(byte) (0x41 ^ 0x20);
        key[12]=(byte) (0xc0 ^ 0x20);
        key[13]=(byte) (0xbb ^ 0x20);
        key[14]=(byte) (0xbf ^ 0x20);
        key[15]=(byte) (0x71 ^ 0x20);
        key[16]=(byte) (0x0d ^ 0x20);
        key[17]=(byte) (0xe5 ^ 0x69);
        key[18]=(byte) (0x90 ^ 0x20);
        key[19]=(byte) (0x88 ^ 0x20);
        key[20]=(byte) (0x74 ^ 0xe3);
        key[21]=(byte) (0x28 ^ 0x20);
        key[22]=(byte) (0x54 ^ 0x20);
        key[23]=(byte) (0x20 ^ 0x20);
        key[24]=(byte) (0x96 ^ 0x20);
        key[25]=(byte) (0x38 ^ 0x20);
        key[26]=(byte) (0xf3 ^ 0x20);
        key[27]=(byte) (0x7c ^ 0x20);
        key[28]=(byte) (0x23 ^ 0x20);
        key[29]=(byte) (0xee ^ 0x74);
        key[30]=(byte) (0x51 ^ 0x2E);











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
            // TODO : modifier la ligne suivante
            byte[] currentMsgBytes = HexConverters.toByteArrayFromHex(messages[i]);
            byte[] firstMsgBytes = HexConverters.toByteArrayFromHex(messages[0]);

            tmpByteMsg = HexConverters.xorArray(currentMsgBytes, firstMsgBytes);

            System.out.print(i);
            System.out.print(": ");

            //System.out.println( HexConverters.toPrintableString(tmpByteMsg));
            System.out.println( HexConverters.toPrintableHexFromByteArray(tmpByteMsg));
            i++;
        }

        // Affichage des messages décodés
        System.out.println();
        System.out.println("Decoded messages :");
        i = 0;
        while (i < nbMsg) {
            // TODO : afficher le message, au lieu des valeur par octet
            tmpByteMsg = HexConverters.xorArray(key, byteArrayMsg[i]);
            System.out.print(i);
            System.out.print(": ");
            System.out.println(HexConverters.toPrintableString(tmpByteMsg));
            i++;
        }
    }
}
