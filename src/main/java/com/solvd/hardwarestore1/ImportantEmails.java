package com.solvd.hardwarestore1;

public enum ImportantEmails {
    PRESIDENT_OF_USA ("iambiden@gmail.com"),
    PRESIDENT_OF_ARGENTINA ("iammilei@gmail.com"),
    PRESIDENT_OF_RUSIA ("iamputin@gmail.com");

    private final String email;
    ImportantEmails(String email){
        this.email=email;
    }

    public static String [] getEmails(){
        String [] arrayWithEmails=new String[3];
        arrayWithEmails[0]= PRESIDENT_OF_USA.email;
        arrayWithEmails[1]= PRESIDENT_OF_ARGENTINA.email;
        arrayWithEmails[2]= PRESIDENT_OF_RUSIA.email;
        /*
        for (String c:arrayWithEmails) {
            System.out.println(c);
        }

         */
        return arrayWithEmails;
    };

}
