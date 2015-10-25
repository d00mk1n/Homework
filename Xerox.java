package homeworkFall2015;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Xerox {

	public static Object deepCopy(Object o) {

		for (int i = 0; i < o.getClass().getInterfaces().length; i++) {
			if (o.getClass().getInterfaces()[i].getSimpleName() != "Serializable") {

				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				byte[] byteArray = new byte[0];

				try {
					ObjectOutputStream oos = new ObjectOutputStream(baos);

					oos.writeObject(o);

					byteArray = baos.toByteArray();

				} catch (IOException e) {
					e.printStackTrace();
				}

				ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);

				try {
					ObjectInputStream ois = new ObjectInputStream(bais);

					Object copy = ois.readObject();

					// System.out.println(copy);

					return copy;

				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
