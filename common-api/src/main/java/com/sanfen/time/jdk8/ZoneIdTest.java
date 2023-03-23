package com.sanfen.time.jdk8;

import java.time.ZoneId;
import java.util.Set;

/**
 * ZoneId
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 10:35
 */
public class ZoneIdTest {

    public static void main(String[] args) {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds.size());
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZoneId zoneId1 = ZoneId.of("Asia/Chongqing");
        System.out.println(zoneId1);
    }

}
