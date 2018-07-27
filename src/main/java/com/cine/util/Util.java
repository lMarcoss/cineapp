package com.cine.util;

import org.apache.log4j.Logger;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Util {
    private static final Logger LOG = Logger.getLogger(Util.class);


    /**
     * Genera los siguientes count dias a partir de la fecha actual
     *
     * @param count
     * @return
     */
    public static List<String> getNextDays(int count) {
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
            nextDays.add(formatDateToddMMyyyy(date));
        }
        return nextDays;
    }

    /**
     * Formatea una fecha de calendar en formato dd-MM-yyyy
     *
     * @param date
     * @return
     */
    private static String formatDateToddMMyyyy(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date);
    }

    /**
     * Guarda la imagen en la ruta resources/images
     *
     * @param multipartFile
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    private static String savePicture(MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws Exception {
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

    /**
     * Crea un nombre de archivo con la nomenclatura: 8_caracteres_aleatorios + nombreDeArchivoOriginal_sin_espacio
     *
     * @param multipartFile
     * @return
     */
    private static String createNameFile(MultipartFile multipartFile) {
        String nameOriginal = multipartFile.getOriginalFilename();
        nameOriginal = nameOriginal.replace(" ", "_");
        String nameFileRandom = randomAlphanumeric(8) + nameOriginal;
        return nameFileRandom;
    }

    /**
     * Genera una cadena con count caracteres aleatorios
     *
     * @param count
     * @return
     */
    public static String randomAlphanumeric(int count) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        while (count-- != 0) {
            int index = (int) (Math.random() * characters.length());
            stringBuilder.append(characters.charAt(index));
        }
        return stringBuilder.toString();
    }

    /**
     * genera la fecha actual en formado dd-MM-yyyy
     *
     * @return
     * @throws ParseException
     */
    public static Date getDateToday() throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateToday = DateTimeFormatter.ofPattern("dd-MM-yyyy", new Locale("es", "ES")).format(localDateTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.parse(dateToday);

    }

    /**
     * @param multipartFile
     * @param httpServletRequest
     * @return (Si no hay archivo retorna null y si no retorna el resultado de savePicture)
     */
    public static String validateAndSavePicture(MultipartFile multipartFile, HttpServletRequest httpServletRequest) {
        String nameFile = null;
        if (!multipartFile.isEmpty()) {
            try {
                nameFile = savePicture(multipartFile, httpServletRequest);
            } catch (Exception e) {
                LOG.error(e.getMessage());
                e.printStackTrace();
                nameFile = null;
            }
        }
        return nameFile;

    }

    /**
     * Imprime los errores de usuario al crear un nuevo objeto
     *
     * @param allErrors
     */
    public static void printError(List<ObjectError> allErrors) {
        for (ObjectError error : allErrors) {
            LOG.error(error.toString());
        }
    }
}
