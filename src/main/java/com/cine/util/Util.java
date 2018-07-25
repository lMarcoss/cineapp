package com.cine.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.events.Characters;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {
    public static List<String> getNextDays(int count) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date start = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, count); // Next N days from now
        Date endDate = calendar.getTime();

        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(start);
        List<String> nextDays = new ArrayList<>();
        while (!gCal.getTime().after(endDate)) {
            Date date = gCal.getTime();
            gCal.add(Calendar.DATE, 1);
            nextDays.add(simpleDateFormat.format(date));
        }
        return nextDays;
    }

    public static String savePicture(MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws Exception {
        String nameFile = createNameFile(multipartFile);
        String pathSave = httpServletRequest.getServletContext().getRealPath("/resources/images/");
        try {
            File imageFile = new File(pathSave + nameFile);
            multipartFile.transferTo(imageFile);
            return nameFile;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private static String createNameFile(MultipartFile multipartFile) {
        String nameOriginal = multipartFile.getOriginalFilename();
        nameOriginal = nameOriginal.replace(" ", "_");
        String nameFileRandom = randomAlphanumeric(8) + nameOriginal;
        return nameFileRandom;
    }

    public static String randomAlphanumeric(int count) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        while (count-- != 0) {
            int index = (int) (Math.random() * characters.length());
            stringBuilder.append(characters.charAt(index));
        }
        return stringBuilder.toString();
    }
}
