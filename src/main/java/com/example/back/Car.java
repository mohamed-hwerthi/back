package com.example.back;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data

public class Car {
    public String color;
    public String type;
    public final ObjectMapper objectMapper = new ObjectMapper().setDefaultPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL , JsonInclude.Include.ALWAYS))  ;
    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    //convert java class to json  :
    public  void testObejctMapper(Car car) {
        try {

            String jsonCar = objectMapper.writeValueAsString(car);
            System.out.println(jsonCar);
        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    //convert json to java class  :
      public void ConvertJsonToJavaClass(){

        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        try {

        Car  car = objectMapper.readValue(json , Car.class) ;
            System.out.println(car);


        }
        catch (Exception e){
            e.printStackTrace() ;


        }
    }





}
