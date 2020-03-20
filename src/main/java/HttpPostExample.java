/*
 * в данной работе будут рассмотрены примеры использования метода POST
 * двумя разными способами
 * 1. реализация POST запроса стандартными средствами java;
 * 2. реализация POST запроса с использованием библиотеки apache http.
 * Все необходимые зависимости уже добавлены. (pom.xml, раздел dependencies)
 * */

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpPostExample {

    //TODO: необходимо разработать класс, имеющий два статичных метода.
    // Первый из которых осуществляет POST запрос стандартными стредствами языка,
    // а второй с использованием сторонней библиотеки apache.
    // Ссылка для запросов:  http://httpbin.org/post

    //TODO: проиициализируйте константу URL, которая будет использоваться для отправки запросов
    private final static String URL = "http://httpbin.org/post";
    private final static String REQUEST_METHOD = "POST";
    private final static String CONTENT_TYPE_HEADER = "Content-type";
    private final static String CONTENT_TYPE_VALUE = "application/json";

    //TODO: внесите свои данные в json бъект ниже (необязательно правдивые)
    private static JSONObject postData = new JSONObject()
            .accumulate("name","YOUR_NAME")
            .accumulate("age","YOUR_AGE");

    public static void main(String[] args) {
        RequestWithApacheLibrary();
        postRequestUsingJava_net();
    }

    //TODO: разработайте метод, который осуществляет get запрос встроенными средствами языка
    private static void postRequestUsingJava_net(){

        //TODO: создайте экземпляр класса URL используя ранее определенную константу URL
        try {
            URL url = new URL(URL);

            //TODO: создайте экземпляр класса HttpURLConnection, используя метод openConnection() класса URL
            // на ранее созданом объекте url
            // (!!! возвращаемое значение необходимо привести к типу HttpURLConnection !!!)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection() ;

            //TODO: используя метод setRequestMethod(), установите метод запроса у объекта connection
            // используя константу REQUEST_METHOD
            connection./*МЕТОД УСТАНОВКИ МЕТОДА ЗАПРОСА*/;
            /*
            * так как в этот раз мы будем отправлять данные, а не получтать, нам требуется
            * добавить свойство запроса (request property), которое даст серверу понять, что
            * именно мы ему посылаем.
            * За тип отправляемого контента в HTTP отвечает свойство Content-type или тип контента.
            * Мы будеи отправлять строку json, поэтому тип контента у нас будет application/json,
            * как вы могли заметить у нас уже имеются соответствующие константы.
            * */

            //TODO: используя метод setRequestProperty() установите свойство запроса,
            // используйте для этого константы (CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE)
            connection./*метод установки новго свойства запроса*/;

            /*
            * в этом примере мы будем использовать поток вывода,
            * для того чтобы записать информацию в наш запрос,
            * поэтому нам нужно разрешить выводить информацию в запрос,
            * у класса HttpURLConnection есть поле булевое поле doOutput
            * и соответствующий сеттер
            * */

            //TODO: используя сеттер setDoOutput() установите значение true
            //connection./*МЕТОД РАЗРЕШАЮЩИЙ ВЫВОД*/;

            //TODO: последовательно используя цепочку вызовов  toString().getBytes()
            // конвертируйте наш json объект в массив байт
            //byte[] postBytes = postData.;

            /*
            * теперь, используя потоки вывода записать наш json объект в запрос
            * */
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.write(postBytes);

            //TODO: используя метод getInputStream() из HttpURLConnection
            // создайте объект InputStream,
            // после чего на его основе создайте объект InputStreamReader
            // и конвертируйте его в BufferedReader
            //InputStream inputStream = ;
            //InputStreamReader inputStreamReader = ;
            //BufferedReader bufferedReader = ;

            //TODO: подготовьте строку и StringBuilder с помощью которых будете считывать ответ
            // (для этого раскоментируйте строки ниже)
            String line;
            StringBuilder response = new StringBuilder();

            //TODO: используя методы BufferedReadep.readLine() и StringBuilder.append()
            // считайте содержимое ответа
            //while (/*УСЛОВИЕ ВЫХОДА ИЗ ЦИКЛА -> bufferedReader.readLine = null*/) {
                //TODO: иплементируйте алгоритм считывания здесь
                //System.out.println(line);

            //}

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void RequestWithApacheLibrary(){
        try {
            //TODO: используя метод createDefault() класса HttpClients
            // создайте экземпляр CloseableHttpClient
            //CloseableHttpClient client = ;

            //TODO: создайте post-запрос, который будет представлен
            // экземпляром класса HttpGet, в качестве параметра используйте константу URL
            //HttpPost request = ;

            /*
            * Content-type, является не просто свойством запроса, но еще и заголовком,
            * поэтому в библиотеке apache используется метод addHeader()
            * */
            //TODO: по аналогии с примером выше, добавьте запросу свойство Content-type
            //request.addHeader(,);

            /*
            * при использовании этой библиотеки, вам не нужно заморачиваться с
            * потоками ввода и вывода, все уже сделано за вас, например,
            * для записи данных в запрос используется простой и лаконичный метод setEntity(),
            * который принимает на вход объект HttpEntity, но будте внимательны, т.к. HttpEntity -
            * интерфейс, следовательно вы не можете создать экземпляр этого класса, но вы можете создать
            * экземпляр одного из классов, имплементирующих его, например StringEntity
            * */
            //TODO: создайте объект StringEntity, при создании используйте конвертированный
            // в строку json объект postData  качестве параметра
            request.setEntity(/*СОЗДАНИЕ ОБЪЕКТА StringEntity()*/);

            //TODO: используя метод execute() (англ. выполнить) на объекте client,
            // созданном ранее, передав в него объект request,
            // создайте экземпляр CloseableHttpResponse,
            // который будет хранить в себе ответ от сервера
            //CloseableHttpResponse response = client./*МЕТОД "ВЫПОЛНИТЬ"*/(/*ЗАПРОС*/);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
