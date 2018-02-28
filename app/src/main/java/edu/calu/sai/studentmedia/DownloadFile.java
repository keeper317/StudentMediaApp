package edu.calu.sai.studentmedia;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import android.os.Environment;

import android.os.AsyncTask;

/**
 * Created by administrator on 2/21/18.
 */
public class DownloadFile extends AsyncTask<String, Void, Void>{

    @Override
    protected Void doInBackground(String... strings) {
        String fileUrl = strings[0];   // 158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf
        String fileName = strings[1];  // "2-2-18.pdf"
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();

        File folder = new File(extStorageDirectory, "StudentMediaApp/Paper");
        folder.mkdir();

        File pdfFile = new File(folder.getAbsolutePath(), fileName);


        try{
            pdfFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        FileDownloader.downloadFile(fileUrl, pdfFile);
        return null;
    }
}



