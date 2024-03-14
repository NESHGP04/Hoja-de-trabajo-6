package test;
import static org.junit.Assert.*;
import org.junit.Test;

import MD5HashMap;
import OrganicoHashMap;
import SHA1HashMap;

public class Hashtest {
    @Test
    public void testHashMD5() {//MD5
        String str = "Kevin es feo";
        String expectedHash = "2023dc91c11bde69e9c26fcc95ac662a";

        MD5HashMap  hashMap = new MD5HashMap();
        String actualHash = hashMap.hash(str);

        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHashorganico() {
        String str = "Kevin es feo";
        String expectedHash = "Kevin es feo";

        OrganicoHashMap  hashMap = new OrganicoHashMap();
        String actualHash = hashMap.hash(str);

        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHashSHA1(){
        String str = "Kevin es feo";
        String expectedHash = "973ec79071f9b63ceaa3f3806d9013705422d414";

        SHA1HashMap  hashMap = new SHA1HashMap();
        String actualHash = hashMap.hash(str);

        assertEquals(expectedHash, actualHash);
    }
}
