package org.rocklass.fullstacklab.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemRepositoryServiceTest {
	// TODO more tests
	@Mock
	private ItemRepository itemRepository;

	private ItemRepositoryService itemRepositoryService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		itemRepositoryService = new ItemRepositoryService();
		itemRepositoryService.setRepository(itemRepository);
	}

	@Test
	public void getRepository() {
		assertSame(itemRepositoryService.getRepository(), itemRepository);
	}

	@Test
	public void getEntityName() {
		assertThat(itemRepositoryService.getEntityName(), equalTo("item"));
	}

	@Test
	public void add() {
		Item item = new Item();

		when(itemRepository.saveAndFlush(any(Item.class))).thenReturn(item);

		assertThat(itemRepositoryService.add(item), sameInstance(item));
	}

	@Test
	public void delete() throws EntityNotFoundException {
		Item item = new Item();
		when(itemRepository.findOne(anyLong())).thenReturn(item);

		itemRepositoryService.delete(1L);

		verify(itemRepository, times(1)).delete(item);
	}

	@Test
	public void deleteEntityNotFoundException() throws EntityNotFoundException {
		thrown.expect(EntityNotFoundException.class);
		itemRepositoryService.delete(1L);
	}

	@Test
	public void findAll() {
		Item item = new Item();
		when(itemRepository.findOne(anyLong())).thenReturn(item);

		itemRepositoryService.findAll();

		verify(itemRepository, times(1)).findAll();
	}

	@Test
	public void findById() throws EntityNotFoundException {
		Item item = new Item();
		when(itemRepository.findOne(anyLong())).thenReturn(item);

		assertThat(itemRepositoryService.findById(1L), sameInstance(item));
	}

	@Test
	public void findByIdEntityNotFoundException()
			throws EntityNotFoundException {
		thrown.expect(EntityNotFoundException.class);
		itemRepositoryService.findById(1L);
	}

	@Test
	public void update() {
		Item item = new Item();

		when(itemRepository.saveAndFlush(any(Item.class))).thenReturn(item);

		assertThat(itemRepositoryService.update(item), sameInstance(item));
	}
}
