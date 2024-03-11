package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean search(ArrayList<Integer> array, int e, double n, int operation, ArrayList<String> array2) {
      System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array)  {
        if (elt == e&& operation == -1) return true;
      }
      
      int pointer1 = 0;
        int pointer2 = array.size()-1;

        while(pointer2 > pointer1){
            pointer1++;
            pointer2--;
        }
        double medianResult = ((double)array.get(pointer1) + array.get(pointer2))/2;
        double precisionDifference = 0.01;
        if(Math.abs(n - medianResult) < precisionDifference && operation == 1){
            return true;
        }
        
        double sum = 0;
        for(int i = 0; i < array.size(); i++){
            sum += array.get(i);
        }
        double meanResult = sum / array.size();
        if(Math.abs(n - meanResult) < precisionDifference && operation == 2){
            return true;
        }
        
        for (String str : array2)  {
        if (str.equals("a")&& operation == 3) return true;
      }
      return false;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
          
          String input5 = req.queryParams("input1");
          java.util.Scanner sc2 = new java.util.Scanner(input5);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            
            inputList2.add(sc2.next().replaceAll("\\s",""));
          }
          System.out.println(inputList2);


         /*Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());*/
        
          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
          
          String input3 = req.queryParams("input3").replaceAll("\\s","");
          double input3AsDouble = Double.parseDouble(input3);
          
          String input4 = req.queryParams("input4").replaceAll("\\s","");
          double input4AsDouble = Double.parseDouble(input4);

          boolean result = App.search(inputList, input2AsInt, 2.0, -1, inputList2);
	  boolean result2 = App.search(inputList, input2AsInt, input3AsDouble, 1, inputList2);
	  boolean result3 = App.search(inputList, input2AsInt, input4AsDouble, 2, inputList2);
	  boolean result4 = App.search(inputList, input2AsInt, input4AsDouble, 3, inputList2);
         Map map = new HashMap();
          
          map.put("result", result);
          map.put("result2", result2);
          map.put("result3", result3);
          map.put("result4", result4);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              map.put("result2", "not computed yet!");
              map.put("result3", "not computed yet!");
              map.put("result4", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}



