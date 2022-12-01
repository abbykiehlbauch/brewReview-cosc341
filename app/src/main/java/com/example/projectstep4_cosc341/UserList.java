package com.example.projectstep4_cosc341;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {

    ArrayList<User> UserList;

    public ArrayList<User> getAccountList() {
        return UserList;
    }

    public UserList(ArrayList<User> listOfUsers) {

        this.UserList = listOfUsers;
    }

    public UserList() {
        this.UserList = null;
    }

    public void writeAccToFile(UserList lOU, Context context) {

        //Open the file to write to
        File directory = new File(context.getFilesDir().getAbsolutePath()
                + File.separator + "serlization");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename = "userList.srl";
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(directory
                    + File.separator + filename));
            //write the objects from the lOU arraylist so they are stored in the fie
            out.writeObject(lOU);
            //close the out object output stream
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static UserList readAccs(Context context) {
        //make the object input stream and array list, along with create a string for the file name
        ObjectInputStream input = null;
        ArrayList<UserList> lOU = null;
        String filename = "userList.srl";
        //open the file you will read from
        File direct = new File(context.getFilesDir().getAbsolutePath() + File.separator + "serlization");

        UserList returnList = null;
        try {
            //declare the ObjectInputStream
            input = new ObjectInputStream(new FileInputStream(direct + File.separator + filename));

            //read the arraylist from the file and store it in return list
            returnList = (UserList) input.readObject();
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (returnList == null) {
            //if return list is null then return a empty list
            UserList rL2 = new UserList();
            return rL2;
        } else {
            //else return the written list
            return returnList;
        }
    }
}
