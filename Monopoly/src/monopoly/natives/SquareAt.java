package monopoly.natives;

import magritte.NativeCode;
import monopoly.Square;

public interface SquareAt extends NativeCode {

	Square squareAt(int position);

}
