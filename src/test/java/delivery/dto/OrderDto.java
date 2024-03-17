package delivery.dto;


import delivery.utils.RandomDataGenerator;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderDto {

    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    int id;

    // static method to use factory
    public static OrderDto createRandomOrder() {
        // builder
        return OrderDto.builder()
                .status("OPEN")
                .courierId(0)
                .customerName(RandomDataGenerator.generateName())
                .customerPhone("12343456")
                .comment("comment")
                .id(1)
                .build();
    }
}

