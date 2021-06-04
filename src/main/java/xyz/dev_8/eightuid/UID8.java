package xyz.dev_8.eightuid;
/*
Created by @8ML (https://github.com/8ML) on June 04 2021
*/

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class UID8 {

    private final char[] chars = new char[]{'A', 'B', 'C', 'E', 'F', 'f', 'H', 'h', 'i', 'J', 'k', 'Q', 'q', 'z'};

    private final long creationEpoch;

    private String uid;

    public UID8() {
        this.creationEpoch = System.currentTimeMillis();
        create();
    }

    public UID8(long epoch, String uid) {
        this.creationEpoch = epoch;
        this.uid = uid;
    }

    public void create() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < String.valueOf(this.creationEpoch).length(); i++) {

            char[] numChars = String.valueOf(this.creationEpoch).toCharArray();
            char[] rndChars = new char[2];

            rndChars[0] = chars[new Random().nextInt(chars.length)];
            rndChars[1] = chars[new Random().nextInt(chars.length)];

            sb.append(i == 0 ? numChars[i] : "-" + numChars[i])
                    .append(":")
                    .append(rndChars[0])
                    .append(rndChars[1]);

        }

        this.uid = sb.toString();

    }

    public String toString() {
        return this.uid;
    }

    public long getCreationEpoch() {
        return creationEpoch;
    }

    public String getCreationDate(String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(Date.from(Instant.ofEpochMilli(this.getCreationEpoch())));
    }

    public static UID8 parse(String uid) {

        StringBuilder epochStr = new StringBuilder();

        String[] sections = uid.split("-");
        for (String section : sections) {
            String[] entries = section.split(":");

            epochStr.append(entries[0]);

        }

        try {

            return new UID8(Long.parseLong(epochStr.toString()), uid);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return null;

    }
}
