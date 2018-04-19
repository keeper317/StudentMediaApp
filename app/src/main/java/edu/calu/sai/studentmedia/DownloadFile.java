package edu.calu.sai.studentmedia;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

public class DownloadFile extends AsyncTask<String, Void, Void>{

    @Override
    protected Void doInBackground(String... strings) {
        String fileUrl = strings[0];   // 158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf
        String fileName = strings[1];  // "2-2-18.pdf"
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();

        File folder = new File(extStorageDirectory, "StudentMediaApp/Paper");
        folder.mkdir();

        File pdfFile = new File(folder.getAbsolutePath(), fileName);
        publishProgress();

        try{
            pdfFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        FileDownloader.downloadFile(fileUrl, pdfFile);
        return null;
    }
}



