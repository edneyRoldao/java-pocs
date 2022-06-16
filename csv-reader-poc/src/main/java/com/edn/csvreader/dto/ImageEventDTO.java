package com.edn.csvreader.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

import java.io.Serializable;

@Data
public class ImageEventDTO implements Serializable {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String companyId;

    @CsvBindByPosition(position = 2)
    private String subjectId;

    @CsvBindByPosition(position = 3)
    private String screenId;

    @CsvBindByPosition(position = 4)
    private String photo;

    @CsvBindByPosition(position = 5)
    private String age;

    @CsvBindByPosition(position = 6)
    private String gender;

    @CsvBindByPosition(position = 7)
    private String group;

    @CsvBindByPosition(position = 8)
    private String shortGroup;

    @CsvBindByPosition(position = 9)
    private String quality;

    @CsvBindByPosition(position = 10)
    private String confidence;

    @CsvBindByPosition(position = 11)
    private String eventType;

    @CsvBindByPosition(position = 12)
    private String subjectType;

    @CsvBindByPosition(position = 13)
    private String realName;

    @CsvBindByPosition(position = 14)
    private String pinyin;

    @CsvBindByPosition(position = 15)
    private String subjectPhoto;

    @CsvBindByPosition(position = 16)
    private String timestamp;

    @CsvBindByPosition(position = 17)
    private String fmp;

    @CsvBindByPosition(position = 18)
    private String fmpError;

    @CsvBindByPosition(position = 19)
    private String cameraPosition;

    @CsvBindByPosition(position = 20)
    private String uuid;

    @CsvBindByPosition(position = 21)
    private String passType;

    @CsvBindByPosition(position = 22)
    private String verificationMode;

    @CsvBindByPosition(position = 23)
    private String temperature;

}
