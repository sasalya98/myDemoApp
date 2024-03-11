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
    public static boolean search(ArrayList<Integer> array, int e) {
      System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array) {
        if (elt == e) return true;
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
          ///////////////////////////////////////////////////// first box
          String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList3 = new java.util.ArrayList<>();
          while (sc3.hasNext())
          {
            int value = Integer.parseInt(sc3.next().replaceAll("\\s",""));
            inputList3.add(value);
          }
          System.out.println(inputList3);
	  ///////////////////////////////////////////////////// third box
	  String input5 = req.queryParams("input5");
          java.util.Scanner sc5 = new java.util.Scanner(input5);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList5 = new java.util.ArrayList<>();
          while (sc5.hasNext())
          {
            //int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList5.add(sc5.next().replaceAll("\\s",""));
          }
          System.out.println(inputList5);
	  ///////////////////////////////////////////////////// fifth box
	  String input7 = req.queryParams("input7");
          java.util.Scanner sc7 = new java.util.Scanner(input7);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList7 = new java.util.ArrayList<>();
          while (sc7.hasNext())
          {
            //int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList7.add(sc7.next().replaceAll("\\s",""));
          }
          System.out.println(inputList7);
	  ///////////////////////////////////////////////////// seventh box
	  String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
	  ///////////////////////////////////////////////////// second box
	  String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);
          ///////////////////////////////////////////////////// fourth box
          String input6 = req.queryParams("input6").replaceAll("\\s","");
          int input6AsInt = Integer.parseInt(input6);
	  ///////////////////////////////////////////////////// sixth box	 
          
          

         /*Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());*/
        
        

         Map map = new HashMap();
          map.put("result2", result2);
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              map.put("result2", "not computed yet!");
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



