package service;

public class BMIService {
	public String getBMI(String height, String weight) {
		//5. 確認有無參數
		if(height == null || weight == null) {
			return "無參數或數值不對";
		}
		
		//6. 進行轉型 String -> double
		double h = 0, w = 0;
		try {
			h = Double.parseDouble(height);
			w = Double.parseDouble(weight);
		}catch(Exception e) {
			return "請輸入正確數值";
		}
		//7. 資料合理性檢查
		if(h < 10 || h > 300) { 
			return "身高數值超過範圍" ;
		}else if(w <10 || w > 1000) {
			return "體重數值超過範圍";
		}
		
		//8. 計算 BMI 值並回傳
		double bmi = w / Math.pow(h/100, 2);
		
		return String.format("身高：%.1f  體重：%.1f  BMI：%.1f", h, w, bmi);
		
	}

}
