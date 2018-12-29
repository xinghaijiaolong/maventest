package com.sr;

import java.nio.ByteBuffer;

public class TestTwo {
    public static void main(String[] args) {
        byte[] k = {0, 0};
        float foo = Float.intBitsToFloat(k[0] ^ k[0]);
        byte[] bytes = float2ByteArray(foo);
        int a = 5;
    }

    public static byte[] float2ByteArray(float value) {
        return ByteBuffer.allocate(4).putFloat(value).array();
    }

    public static byte[] double2Bytes(double d) {
        long value = Double.doubleToRawLongBits(d);
        byte[] byteRet = new byte[8];
        for (int i = 0; i < 8; i++) {
            byteRet[i] = (byte) ((value >> 8 * i) & 0xff);
        }
        return byteRet;
    }

}
