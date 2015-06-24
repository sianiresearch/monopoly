package monopoly.natives;

import magritte.NativeCode;
import monopoly.Square;

public interface Position extends NativeCode {

	int position(Square square);

}
