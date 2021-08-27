package dao.serializado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

import dao.base.IBorrador;

public class BorradorSerializado <T> implements IBorrador<T> {
	private boolean estado = false;
	
	@Override
	public boolean Borrar(String path) {
		File file = new File(path);
		FileOutputStream flujoW;
		try {
			boolean existe = file.exists();
			flujoW = new FileOutputStream(file);
			if (existe) {
				flujoW.write(new String("").getBytes());
				flujoW.flush();
				flujoW.close();
				file.deleteOnExit();					
				estado=true;
			}
			
		} catch (Exception e) {
			estado=false;
		}
		return estado;
	}

}
