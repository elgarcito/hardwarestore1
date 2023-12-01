package com.solvd.hardwarestore1;

public enum ImportantEmails {
    PRESIDENT_OF_USA ("iambiden@gmail.com"),
    PRESIDENT_OF_ARGENTINA ("iammilei@gmail.com"),
    PRESIDENT_OF_RUSSIA("iamputin@gmail.com");

    private final String EMAIL;
    ImportantEmails(String email){
        this.EMAIL=email;
    }

     static String [] getEmails(){
        String [] arrayWithEmails=new String[3];
        arrayWithEmails[0]= PRESIDENT_OF_USA.EMAIL;
        arrayWithEmails[1]= PRESIDENT_OF_ARGENTINA.EMAIL;
        arrayWithEmails[2]= PRESIDENT_OF_RUSSIA.EMAIL;
        /*
        for (String c:arrayWithEmails) {
            System.out.println(c);
        }

         */
        return arrayWithEmails;
    };

}
