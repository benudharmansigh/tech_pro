package com.promotionengine.promotion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EngineApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public Double applyPromotionsTest() {
        double price = 100.0;
        boolean isPromoActive = true;

        Double result = this.restTemplate.getForObject(
                "http://localhost:" + port + "/apply-promotion?price=" + price + "&isPromoActive=" + isPromoActive,
                Double.class);

        assertThat(result).isEqualTo(90.0);

        return result;
    }

}
