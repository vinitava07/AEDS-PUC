import java.io.RandomAccessFile;

public class TP1E09 {
    public static void main(String[] args) throws Exception {
        int num = MyIO.readInt(); 
        double r;
        RandomAccessFile arquivo = new RandomAccessFile ("arquivo", "rw"); // abrir arquivo (escrita)
			for (int i = 0; i < num; i++){
				r = MyIO.readDouble();
				arquivo.writeDouble(r);
			}
			arquivo.close();
			RandomAccessFile file = new RandomAccessFile ("arquivo", "r"); // abrir arquivo (leitura)
			file.seek(num * 8 - 8);	
			for (int j = 1; j < num; j++){
				r = file.readDouble();
				if (r % 1 == 0)
					MyIO.println((int)r);
				else
					MyIO.println(r);
				file.seek(file.getFilePointer() - 16);
			}
			MyIO.println(file.readDouble());
			file.close();
    }

}
