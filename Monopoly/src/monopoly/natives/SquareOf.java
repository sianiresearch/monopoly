package monopoly.natives;

import magritte.NativeCode;
import monopoly.Square;

public interface SquareOf extends NativeCode {

	Square squareOf(Class<? extends Square> aClass);

}
