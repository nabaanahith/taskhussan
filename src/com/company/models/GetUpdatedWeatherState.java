//package com.company.entites;
//
/////////////////////////////meth1//////////////////
//import com.company.api.Clint;
//import com.company.helpers.WeatherResponseInterface;
//import com.company.api.OpenWeatherMap;
//import com.company.entites.Sys;
//import com.company.entites.WeatherResponse;
//import com.company.entites.Wind;
//import com.company.models.DateConverter;
//
//import java.io.IOException;
//import java.util.*;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//import retrofit2.Call;
//import retrofit2.Response;
//
//public class GetUpdatedWeatherState implements ModelInterface{
//    private List<Weather> weatherListResponse;
//    private WeatherResponse weatherResponse;
//    private static ScheduledExecutorService execService = null;
//    private static int timesAsleep = 0;
//    List<Weather> list = new ArrayList<>(); /
//
//    List<Weather> list2 = new ArrayList<>();
//    static int o=0;
//    //HashMap<String, Weather> mapResault = new HashMap<>();
//
//    private Wind wind = new Wind();
//    private int timer = 20;
//    private DateConverter dateConverter;
//    boolean removeFirstElementList = false;
//    boolean arrayElementNotEquiled = false;
//    String sighn = "+";
//    private ScheduledExecutorService exec;
//
//    public GetUpdatedWeatherState() {
//        weatherListResponse = new ArrayList<>();
//
//        dateConverter = new DateConverter();
//    }
//
//    @Override
//    public void GetWeatherInformation(String id, String flag, final WeatherResponseInterface callBackResponse) {
//        //System.out.printf("\r%s","city"+" \t\t\t\t\t temp" +" \t\t\t\t\t  humidity"+" \t\t\t\t\t  change"+ "");
//
//        execService = Executors.newScheduledThreadPool(5);
//        execService.schedule(new MyTask(), 2000, TimeUnit.MILLISECONDS);
//
//
//    }
//    private static void setDirection(Weather weatherResponse) {
//        weatherResponse.setDirection(getDirectionInStringFormat(weatherResponse.getDegree()));
//    }
//    public static String getDirectionInStringFormat(double x)
//    {
//
//        String directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW", "N"};
//        return directions[ (int)Math.round((  ((double)x % 360) / 45)) ];
//    }
//
//
//
//    public static class MyTask   implements Runnablle  {
//        static List<Weather> list = new ArrayList<>();
//        static  List<Weather>llll=new ArrayList<>();
//
//        static Weather weather;
//        static List<Weather> list2 = new ArrayList<>();
//        static WeatherResponse weatherResponse;
//        String a[] = {"97783", "98862", "99532", "94787", "98854"};
//        static int i = -1;
//        static double l[]=new double[2];
//        static double l2[]=new double[3];
//        public synchronized void run()  {
//
//            execService.schedule(new MyTask(), 2000, TimeUnit.MILLISECONDS);
//
//            try {
//                synchronized (MyTask.class) {
//
//
//                    Thread.sleep(5000);
//
//                    if (i == 4) {
//                        i = -1;
//                    }
//                    i++;
//
////                    System.out.println("awoke " + "----------------------" + Thread.currentThread().getName());
////                    System.out.println(i);
//                    final OpenWeatherMap apiServices = Clint.getRetrofit().create(OpenWeatherMap.class);
//                    Call<WeatherResponse> call = apiServices.getWeatherization(a[i], DateConverter.API_KEY, "metric");
//                    Response<WeatherResponse> result = call.execute();
//                    DateConverter dateConverter = new DateConverter();
//                    ///  System.out.println("re11111 \t" + result.body().getName());
//
//                    weather = new Weather(result.body().getMain().getTemp(), result.body().getName(), result.body().getWind().getDirectio(), dateConverter.getDateNow(), result.body().getMain().getHumidity(), result.body().getWind().getDeg());
//                    setDirection(weather);
//                    Collections.sort(list, (o1, o2) -> (int) ((o1.getTemp()) - (o2.getTemp())));
//                    if(list.size()==5){
//                        list2.addAll(list);
//
//                        //System.out.println("am list2"+list2.size());
//                     //compare(list,list2);
//                        llll.addAll(compare(list,list2));
//                        list.clear();
//                       // System.out.println(list.size()+" fom com      "+llll.toString());
//                        for(int i=0; i<llll.size(); i++){
//                        System.out.print("\r"+llll.get(i).getTemp()+llll.get(i).getName()+"\n");
//                        }
//                        llll.clear();
//
//                    }
//                    list.add(weather);
//
//                  //  System.out.println("am lll:  "+llll.toString());
//                   // System.out.println("am list:  "+list.toString());
//                        //timer=timer*2;
//                  //  System.out.println("am lll:  "+list.toString());
//
//                }
//
//
////                for(int ii=0; ii<list.size(); ii++){
////                    if(list.get(ii).getSighn()!=null){
////                    System.out.println("  " + list.get(ii).getName()+"\t" +list.get(ii).getTemp()+ " "+list.get(ii).getSighn());}
////                    System.out.println("  " + list.get(ii).getName() +"\t"+list.get(ii).getTemp()+ " ");
////                    System.out.println("  ------------------------------  ");
////
////
////                }
//
//
//            } catch(InterruptedException e){
////                // TODO Auto-generated catch block
////                e.printStackTrace();
//            } catch(IOException e){
//                e.printStackTrace();
//            }
//        }
//
//
//
//            public List<Weather> compare(List<Weather> o1,List<Weather>  o2) {
//
//                for (int i=0; i<o1.size(); i++){
//
//
//
//                if (o1.get(i).getTemp() > o1.get(i).getTemp()) //
//              o1.get(i).setSighn("+");
//                else if (o1.get(i).getTemp() > o1.get(i).getTemp()) {
//                    o1.get(i).setSighn("-");
//                }
//                    o1.get(i).setSighn("not change");
//            }
//                return o1;
//        };
//    }
//
//
//}


//
//package com.company.entites;
///////////////////////////////////////methode 2/////////////////////////////
//
//import com.company.api.Clint;
//import com.company.helpers.WeatherResponseInterface;
//import com.company.api.OpenWeatherMap;
//import com.company.entites.WeatherResponse;
//import com.company.entites.Wind;
//import com.company.models.DateConverter;
//
//import java.io.IOException;
//import java.util.*;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//import com.sun.jdi.request.InvalidRequestStateException;
//import io.reactivex.Observable;
//import io.reactivex.internal.operators.observable.ObservableCreate;
//import retrofit2.Call;
//import retrofit2.Response;
//
//public class GetUpdatedWeatherState implements ModelInterface {
//    private List<Weather> weatherListResponse;
//    private WeatherResponse weatherResponse;
//    private static ScheduledExecutorService execService = null;
//    private static int timesAsleep = 0;
//    List<Weather> list = new ArrayList<>(); // make this list as live data ok like this :
//
//    List<Weather> list2 = new ArrayList<>();
//    static int o = 0;
//    // string is city name or id ok ?ok
//    HashMap<String, List<Weather>> mapResault = new HashMap<>();
//    HashMap<String, Weather> mResault = new HashMap<>();
//    private  int timer = 20000;
//    private DateConverter dateConverter;
//    private OpenWeatherMap apiServices;
//    private String[] cities = {"97783", "98862", "99532", "94787", "98854"};
//
//    public GetUpdatedWeatherState() {
//        weatherListResponse = new ArrayList<>();
//
//        dateConverter = new DateConverter();
//    }
//
//    @Override
//    public void GetWeatherInformation(String id, String flag, final WeatherResponseInterface callBackResponse) {
//        System.out.printf("\r%s","city"+" \t\t\t\t\t temp" +" \t\t\t\t\t  humidity"+" \t\t\t\t\t  change"+" \t\t\t\t\t  last update"+"");
//System.out.println("hi am GetWeatherInformation");
//        execService = Executors.newScheduledThreadPool(5);
//
//        apiServices = Clint.getRetrofit().create(OpenWeatherMap.class);
//
//
//
//        for (String city : cities) {
//
//            mapResault.put(city, new ArrayList<>());
//            // every 1s make requst
//
//
//            execService.scheduleAtFixedRate(new GetWeatherTask(city), 10, timer, TimeUnit.MILLISECONDS);
//        }
//
//
//
//    }
//
//    private static void setDirection(Weather weatherResponse) {
//        weatherResponse.setDirection(getDirectionInStringFormat(weatherResponse.getDegree()));
//    }
//
//    public static String getDirectionInStringFormat(double x) {
//
//        String directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW", "N"};
//        return directions[(int) Math.round((((double) x % 360) / 45))];
//    }
//
//
////    public static class MyTask implements Runnablle {
////        static List<Weather> list = new ArrayList<>();
////        static Weather weather;
////
////        String a[] = {"97783", "98862", "99532", "94787", "98854"};
////        static int i = -1;
////        static double l[] = new double[2];
////        static double l2[] = new double[3];
////
////        public synchronized void run() {
////
////            execService.schedule(new MyTask(), 2000, TimeUnit.MILLISECONDS);
////
////            try {
////                synchronized (MyTask.class) {
////
////
////                    Thread.sleep(5000);
////
////                    if (i == 4) {
////                        i = -1;
////                    }
////                    i++;
////
//////                    System.out.println("awoke " + "----------------------" + Thread.currentThread().getName());
//////                    System.out.println(i);
////                    final OpenWeatherMap apiServices = Clint.getRetrofit().create(OpenWeatherMap.class);
////                    Call<WeatherResponse> call = apiServices.getWeatherization(a[i], DateConverter.API_KEY, "metric");
////                    Response<WeatherResponse> result = call.execute();
////                    DateConverter dateConverter = new DateConverter();
////                    ///  System.out.println("re11111 \t" + result.body().getName());
////
////                    weather = new Weather(result.body().getMain().getTemp(), result.body().getName(), result.body().getWind().getDirectio(), dateConverter.getDateNow(), result.body().getMain().getHumidity(), result.body().getWind().getDeg());
////                    setDirection(weather);
////                    Collections.sort(list, (o1, o2) -> (int) ((o1.getTemp()) - (o2.getTemp())));
////                    list.add(weather);
////                    if (list.size() == 2) {
////                        if (list.get(0).getTemp() < list.get(1).getTemp()) {
////                            weather.setSighn("+");
////                            list.remove(0);
////
////                        } else if (list.get(0).getTemp() > list.get(1).getTemp()) {
////                            weather.setSighn("-");
////                            list.remove(0);
////                        } else {
////                            weather.setSighn("no change");
////                            list.remove(0);
////
////                        }
////                    } else {
////                        weather.setSighn("no change");
////                    }
////
////                    System.out.println("re2222 \t" + weather.getName() + "\t" + weather.getDirection() + "\t" + weather.getSighn());
//////
////
////
////                }
////
////
////            } catch (InterruptedException e) {
//////                // TODO Auto-generated catch block
//////                e.printStackTrace();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////
////        private void compare(List<Weather> list2, List<Weather> list) {
////            for (int i = 0; i < list.size(); i++) {
////
////                if (list.get(i).getTemp() > list2.get(i).getTemp()) {
////                    list.get(i).setSighn("+");
////                } else if (list.get(i).getTemp() < list2.get(i).getTemp()) {
////                    list.get(i).setSighn("-");
////                } else {
////                    list.get(i).setSighn("not change");
////
////                }
////            }
////
////        }
////    }
//
//
//    private class GetWeatherTask implements Runnablle {
//        private String cityId;
//        int changed;
//
//        public GetWeatherTask(String cityId) {
//            this.cityId = cityId;
//        }
//
//        @Override
//        public void run() {
//            // System.out.println("Thread (" + Thread.currentThread().getId() + ")");
//            Call<WeatherResponse> call = apiServices.getWeatherization(cityId, DateConverter.API_KEY, "metric");
//            Response<WeatherResponse> result = null;
//            try {
//                //  System.out.println("timer"+timer);
//
//                result = call.execute();
//
//                if (result.isSuccessful()) {
//                    DateConverter dateConverter = new DateConverter();
//                    Weather newValeu = new Weather(result.body().getMain().getTemp(), result.body().getName(), result.body().getWind().getDirectio(), dateConverter.getDateNow(), result.body().getMain().getHumidity(), result.body().getWind().getDeg());
//                    setDirection(newValeu);
//                    list.add(newValeu);
//                    Collections.sort(list, (o1, o2) -> (int) ((o1.getTemp()) - (o2.getTemp())));
//
//
//                    mapResault.get(cityId).add(newValeu);
//
//                    Weather oldValeu = mResault.get(cityId);
//                    //  null at first time
//                    if(oldValeu!=null) {
//                        if (newValeu.getTemp() == oldValeu.getTemp() && changed == 0) {
//                            timer = timer * 2;
//                        }
//                    }
//
//
//                    if (oldValeu != null) {
//                        changed = weatherComparator.compare(newValeu, oldValeu);
//
//                        if (changed > 0){
//                            newValeu.setSighn("+");
//                        }
//                        else if(changed <0){
//                            newValeu.setSighn("-");
//
//                        }
//                        else {
//                            newValeu.setSighn("not change");
//
//                        }
//
//                    }else mResault.put(cityId,newValeu);
//
//                    mResault.replace(cityId, newValeu); // update old value with new one
//                    // printCityListInfo(mapResault.get(cityId));
////if(list.size()==5) {
//                    int c=0;
////    System.out.println(newValeu.getName()+newValeu.getTemp()+newValeu.getSighn()
////           +newValeu.getDate()+newValeu.getDegree()
////
////    );
////    c++;
////if(c>5) {
////    System.out.print("\r" + newValeu.getName() + newValeu.getTemp() + newValeu.getSighn()
////            + newValeu.getDate() + newValeu.getDegree());
////}
//                    if(list.size()==5) {
////    System.out.print("\r" + list.get(1).toString() +
////            "\n" + list.get(2).toString()
////
////    );
//printCityListInfo(list);
//                        list.clear();
//                    }
//
////    System.out.print("\r"+list.get(2).getName()+list.get(2).getTemp());
//
//
//                    // System.out.print("\r%s" +list.get(1).getTemp());
//                    ;
//                }
//                // System.out.println("mResault"+mResault.get(0));
//
//
//                //  }
//
//                else {
//                    //System.out.println("not success : "+result.message());
//                    System.out.println("not success : " + result.errorBody().string());
//                }
////                if(list.size()==5) {
////                       System.out.print("" + list.toString() + "");}
////                        Thread.sleep(2000);
////                      // System.out.print("\r" + list.get(0).getName() +list.get(0).getTemp()+"\n"+list.get(1).getName() +list.get(1).getTemp());
////                  //  System.out.print("\r" + list.get(1).getName() +list.get(1).getTemp());
////
////                    list.clear();
////
////             }
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//
//
//        }
//
//        private void printCityListInfo(List<Weather> weathers) {
//            if (weathers.size() == 0)
//                return;
//            for (Weather weather : weathers) {
//                System.out.println(weather.getName() +"\t\t\t\t\t\t\t\t"+weather.getTemp()+"\t\t\t\t\t\t\t\t"+weather.getHumidity()+"\t\t\t\t\t\t\t\t"+weather.getSighn()+"\t\t\t\t\t\t\t\t"+weather.getDate());
//
//            }
//            System.out.println("================================================================================================");
//
//        }
//    }
//
//
//    private Comparator<Weather> weatherComparator = new Comparator<>() {
//        @Override
//        public int compare(Weather o1, Weather o2) {
//            if (o1.getTemp() != o2.getTemp())
//                return 1;
//            else if (o1.getTemp() < o2.getTemp())
//                return -1;
//
//
//            return 0;
//        }
//    };
//
//}
//
//

/////////////////////////////////////methode 3/////////////////////////////
package com.company.models;

import com.company.helpers.WeatherResponseInterface;
import com.company.entites.Weather;

import java.util.*;

public class GetUpdatedWeatherState {

    private HashMap<String, List<Weather>> map = new HashMap<>();
    private HashMap<String, double[]> map2 = new HashMap<>();



String a[]={"97783","98854","99532","94787","98862"};

    public void GetWeatherInformation(WeatherResponseInterface weatherResponseInterface) {
        Runnablle runnablle=new Runnablle();
        runnablle.getResponse(a,weatherResponseInterface);


}



}


























