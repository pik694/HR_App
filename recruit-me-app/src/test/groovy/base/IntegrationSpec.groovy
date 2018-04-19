package base

import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import pik.pw.recruitme.app.RecruitMeAppApplication
import pik.pw.recruitme.app.infrastructure.config.Profiles
import spock.lang.Specification

import javax.transaction.Transactional

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment

@ActiveProfiles([Profiles.TEST])
@ContextConfiguration
@SpringBootTest(
        classes = [RecruitMeAppApplication],
        webEnvironment = WebEnvironment.MOCK
)
@Transactional
@Rollback
abstract class IntegrationSpec extends Specification {

    @Autowired
    protected WebApplicationContext webApplicationContext

    MockMvc mockMvc

    @Before
    void setUpMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                .apply(springSecurity())
                .build()
    }

}

