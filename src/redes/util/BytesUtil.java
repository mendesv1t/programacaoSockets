package redes.util;

import java.util.Arrays;

public class BytesUtil {

    public static byte[] trim(byte[] arr)
    {
        byte[] output = null;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] != 0) {
                if (output == null) {
                    output = new byte[i+1];
                }
                output[i] = arr[i];
            }
        }

        if (output == null) { // cover case where input is all 0s
            output = new byte[0];
        }

        return output;
    }
}
