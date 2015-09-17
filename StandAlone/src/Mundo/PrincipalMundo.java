package Mundo;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Interfaz.Principal;

public class PrincipalMundo 
{
	private int id_estacion;

	private ArrayList<Vcub> vcubesTotal;

	private ArrayList<Vcub> vcubesDisponibles;

	private ArrayList<Vcub> vcubesOcupados;
	
	private ArrayList<Vcub> vcubesNoDisponibles;
	
	public PrincipalMundo(int pid, int modo)
	{
		
		vcubesTotal = new ArrayList<Vcub>();
		vcubesDisponibles = new ArrayList<Vcub>();
		vcubesOcupados = new ArrayList<Vcub>();
		vcubesNoDisponibles = new ArrayList<Vcub>();
		id_estacion = pid;
		//////////////////
		try {
			URL todos = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/"+id_estacion);
			InputStream is = todos.openConnection().getInputStream();

			BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );

			String line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			        double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesTotal.add(nuevo);
			}
			   
			}
			reader.close();
			
			URL disp = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/disponibles/"+id_estacion);
			is = disp.openConnection().getInputStream();

			 reader = new BufferedReader( new InputStreamReader( is )  );

			line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			       double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesDisponibles.add(nuevo);
			}
			   
			}
			reader.close();
			
			URL ocu = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/ocupados/"+id_estacion);
			is = ocu.openConnection().getInputStream();

			 reader = new BufferedReader( new InputStreamReader( is )  );

			line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			       double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesOcupados.add(nuevo);
			}
			   
			}
			reader.close();
			
			URL nd = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/nodisponibles/"+id_estacion);
			is = nd.openConnection().getInputStream();

			 reader = new BufferedReader( new InputStreamReader( is )  );

			line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			       double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");	
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesNoDisponibles.add(nuevo);
			}
			   
			}
			reader.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(modo==1)
		{
			reducirDisponibles();
		}
		revisarIncidente();
	}
	
	
	
	
	
	public int getId_estacion() {
		return id_estacion;
	}





	public void setId_estacion(int id_estacion) {
		this.id_estacion = id_estacion;
	}





	public ArrayList<Vcub> getVcubesTotal() {
		return vcubesTotal;
	}





	public void setVcubesTotal(ArrayList<Vcub> vcubesTotal) {
		this.vcubesTotal = vcubesTotal;
	}





	public ArrayList<Vcub> getVcubesDisponibles() {
		return vcubesDisponibles;
	}





	public void setVcubesDisponibles(ArrayList<Vcub> vcubesDisponibles) {
		this.vcubesDisponibles = vcubesDisponibles;
	}





	public ArrayList<Vcub> getVcubesOcupados() {
		return vcubesOcupados;
	}





	public void setVcubesOcupados(ArrayList<Vcub> vcubesOcupados) {
		this.vcubesOcupados = vcubesOcupados;
	}





	public ArrayList<Vcub> getVcubesNoDisponibles() {
		return vcubesNoDisponibles;
	}





	public void setVcubesNoDisponibles(ArrayList<Vcub> vcubesNoDisponibles) {
		this.vcubesNoDisponibles = vcubesNoDisponibles;
	}

	
	public Vcub alquilarVcub()
	{
		Vcub alq = null;
		try {
			
			URL todos = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/estacion/"+id_estacion+"/alquilar/");
			HttpURLConnection httpCon = (HttpURLConnection) todos.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("PUT");
			InputStream is = httpCon.getInputStream();
			
			BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
			
			String line = null;
			while( ( line = reader.readLine() ) != null )  {
				System.out.println(line);
				JSONObject ac = new JSONObject(line);
				if(ac.length()>0)
				{
					int id = ac.getInt("id");
					int estacion = ac.getInt("estacion");
					double lat = ac.getDouble("latitud");
					double lon = ac.getDouble("longitud");
					alq = new Vcub(id,estacion);
					alq.setLatitud(lat);
					alq.setLongitud(lon);
				}
			}
			reader.close();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		revisarIncidente();
		return alq;
	}
	
	public boolean devolverVcub(int idVcub, int esta)
	{
		Vcub alq = null;
		try {
			
			URL todos = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/estacion/"+esta+"/liberar/"+idVcub);
			HttpURLConnection httpCon = (HttpURLConnection) todos.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("PUT");
			InputStream is = httpCon.getInputStream();
			
			BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
			
			String line = null;
			while( ( line = reader.readLine() ) != null )  {
				System.out.println(line);
				JSONObject ac = new JSONObject(line);
				if(ac.length()>0)
				{
					int id = ac.getInt("id");
					int estacion = ac.getInt("estacion");
					double lat = ac.getDouble("latitud");
					double lon = ac.getDouble("longitud");
					alq = new Vcub(id,estacion);
					alq.setLatitud(lat);
					alq.setLongitud(lon);
				}
			}
			reader.close();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(alq!=null)
		{
			return true;
		}
		else return false;
	}

	public Vcub actualizarPosicionVcub(int idvcub,double latitud, double longitud)
	{
		Vcub alq = null;
		try {
			
			URL todos = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcub/"+idvcub+"/"+longitud+"_"+latitud);
			HttpURLConnection httpCon = (HttpURLConnection) todos.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("PUT");
			InputStream is = httpCon.getInputStream();
			
			BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
			
			String line = null;
			while( ( line = reader.readLine() ) != null )  {
				System.out.println(line);
				JSONObject ac = new JSONObject(line);
				if(ac.length()>0)
				{
					int id = ac.getInt("id");
					int estacion = ac.getInt("estacion");
					double lat = ac.getDouble("latitud");
					double lon = ac.getDouble("longitud");
					alq = new Vcub(id,estacion);
					alq.setLatitud(lat);
					alq.setLongitud(lon);
				}
			}
			reader.close();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alq;
	}
	
	public void actualizarListas()
	{
		vcubesTotal = new ArrayList<Vcub>();
		vcubesDisponibles = new ArrayList<Vcub>();
		vcubesOcupados = new ArrayList<Vcub>();
		vcubesNoDisponibles = new ArrayList<Vcub>();
		try {
			URL todos = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/"+id_estacion);
			InputStream is = todos.openConnection().getInputStream();

			BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );

			String line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			        double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesTotal.add(nuevo);
			}
			   
			}
			reader.close();
			
			URL disp = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/disponibles/"+id_estacion);
			is = disp.openConnection().getInputStream();

			 reader = new BufferedReader( new InputStreamReader( is )  );

			line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			       double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesDisponibles.add(nuevo);
			}
			   
			}
			reader.close();
			
			URL ocu = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/ocupados/"+id_estacion);
			is = ocu.openConnection().getInputStream();

			 reader = new BufferedReader( new InputStreamReader( is )  );

			line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			       double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesOcupados.add(nuevo);
			}
			   
			}
			reader.close();
			
			URL nd = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/vcubes/nodisponibles/"+id_estacion);
			is = nd.openConnection().getInputStream();

			 reader = new BufferedReader( new InputStreamReader( is )  );

			line = null;
			while( ( line = reader.readLine() ) != null )  {
			   System.out.println(line);
			   //JSONObject jstart = new JSONObject(line);
			   JSONArray jsonArray = new JSONArray(line);
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject ac = jsonArray.getJSONObject(i);
			        int id = ac.getInt("id");
			       int estacion = ac.getInt("estacion");
			       double lat = ac.getDouble("latitud");
			        double lon = ac.getDouble("longitud");	
			        Vcub nuevo = new Vcub(id,estacion);
			        nuevo.setLatitud(lat);
			        nuevo.setLongitud(lon);
			        vcubesOcupados.add(nuevo);
			}
			   
			}
			reader.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reducirDisponibles()
	{
		try {
			URL todos = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/estacion/"+id_estacion+"/reducir");
			HttpURLConnection httpCon = (HttpURLConnection) todos.openConnection();
			httpCon.setRequestMethod("PUT");
			InputStream is = httpCon.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void revisarIncidente()
	{
		if((vcubesDisponibles.size()+vcubesOcupados.size()+vcubesNoDisponibles.size())*0.1>=vcubesDisponibles.size())
		{
			try {
				URL todos = new URL("http://localhost:8080/mueblesdelosalpes.servicios/webresources/Estacion/estacion/"+id_estacion+"/aumentar");
				HttpURLConnection httpCon = (HttpURLConnection) todos.openConnection();
				httpCon.setRequestMethod("PUT");
				InputStream is = httpCon.getInputStream();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}


}
