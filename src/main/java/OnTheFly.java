import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OnTheFly {
	public List<String> getEvenIndexedValue(String[] names) {
		//List<String> evenNames = IntStream.range(0, names.length);
		String fileHeaders[] = {"a","b","c","License","d","username"};

		Map<String,Integer> index1 = new HashMap<>();
		IntStream
			.range(0, fileHeaders.length)
			.filter(header -> "License".equals(fileHeaders[header]) || "username".equals(fileHeaders[header]) || "".equals(fileHeaders[header]))
			.mapToObj(i -> index1.put(fileHeaders[i],i))
			.collect(Collectors.toList())
		;
		//System.out.println( index1.size() + ":" +  intValues.size());
		//System.out.println( index1.get("License"));
		for(String val : index1.keySet()){
			System.out.println(val + " : " + index1.get(val));
		}
		return new ArrayList<String>();
	}
}
