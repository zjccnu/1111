package com.example.administrator.xmljasondemo.URLbeen;

/**
 * Created by Administrator on 2016/8/27.
 */

import java.util.Arrays;

/**
 * Created by abiguime on 2016/8/26.
 */

public class Indentify /* 身份 */ {

 /*
 {
  "firstName": "John",
  "lastName": "Smith",
  "isAlive": true,
  "age": 25,
  "address": {
    "streetAddress": "21 2nd Street",
    "city": "New York",
    "state": "NY",
    "postalCode": "10021-3100"
  },
  "phoneNumbers": [
    {
      "type": "home",
      "number": "212 555-1234"
    },
    {
      "type": "office",
      "number": "646 555-4567"
    },
    {
      "type": "mobile",
      "number": "123 456-7890"
    }
  ],
  "children": [],
  "spouse": null
}*/
    public String firstName, lastName;
    public boolean isAlive;
    public int age;
    public Ad address;
    public PN[] phoneNumbers;
    public String[] children;


    @Override
    public String toString() {
        return "Identity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isAlive=" + isAlive +
                ", age=" + age +
                ", address=" + address +
                ", phoneNumbers=" + Arrays.toString(phoneNumbers) +
                ", children=" + Arrays.toString(children) +
                '}';
    }

    public class PN {
        public String type, number;

        @Override
        public String toString() {
            return "PN{" +
                    "type='" + type + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }

    public class Ad {

        public String streetAddress, city, state, postalCode;

        @Override
        public String toString() {
            return "Ad{" +
                    "streetAddress='" + streetAddress + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    '}';
        }
    }

}

