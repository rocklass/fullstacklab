package org.rocklass.fullstacklab.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rocklass.fullstacklab.repository.ItemRepository;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
// TODO write repository test
public class ItemRepositoryTest {
	
//	@Autowired
    private ItemRepository itemRepositoryMock;

	@Test
	public void findAll() throws Exception {
	}
}
