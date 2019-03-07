package sun.ajaxJava.practice.fetchData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;


@WebServlet("/GetCountry")
public class GetCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		out.append("Served at: ").append(request.getContextPath());
		ArrayList<Country> countryList = new ArrayList<Country>();
		countryList = FetchData.getAllCountry();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(countryList, new TypeToken<List<Country>>(){}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		out.print(jsonArray);
		System.out.println(jsonArray);
	}

}
