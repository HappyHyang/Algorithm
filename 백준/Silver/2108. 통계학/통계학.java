import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());

		int[] nums = new int[N];
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(input.readLine());
		}
		Arrays.sort(nums);

		// 산술평균
		output.append(Math.round(Arrays.stream(nums).average().orElse(0.0))).append("\n");
		// 중앙값
		output.append(nums[N / 2]).append("\n");
		// 최빈값
		output.append(최빈값(nums)).append("\n");
		// 범위
		output.append(nums[N - 1] - nums[0]).append("\n");

		System.out.print(output);
	}

	static int 최빈값(int[] nums) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
		entryList.sort((e1, e2) -> {
			if (e2.getValue().equals(e1.getValue())) {
				return Integer.compare(e1.getKey(), e2.getKey());
			}
			return Integer.compare(e2.getValue(), e1.getValue());
		});

		if (entryList.size() > 1 && entryList.get(0).getValue().equals(entryList.get(1).getValue())) {
			return entryList.get(1).getKey();
		} else {
			return entryList.get(0).getKey();
		}
	}
}