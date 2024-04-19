package design_pattern.builder;

public class BuilderTest {
	public static void main(String[] args) {
		Computer c1 = new Computer.ComputerBuilder("512", "16")
				.setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true)
				.build();
		System.out.println(c1);
		
		Computer c2 = Computer.builder("512", "16").setBluetoothEnabled(true).build();
		System.out.println(c2);
	}

}
