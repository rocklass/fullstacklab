package org.rocklass.fullstacklab.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.repository.ItemRepository;
import org.rocklass.fullstacklab.test.tools.RandomFactory;

@RunWith(MockitoJUnitRunner.class)
public class ItemRepositoryServiceTest {

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
        assertThat(itemRepositoryService.getRepository(), sameInstance(itemRepository));
    }

    @Test
    public void getEntityName() {
        assertThat(itemRepositoryService.getEntityName(), equalTo("item"));
    }

    @Test
    public void add() {
        // given
        final Item item = RandomFactory.createItem();
        when(itemRepository.saveAndFlush(any(Item.class))).thenReturn(item);

        // when
        final Item addedItem = itemRepositoryService.add(item);

        // then
        assertThat(addedItem, sameInstance(item));
        verify(itemRepository, times(1)).saveAndFlush(Matchers.refEq(item));
    }

    @Test
    public void delete() throws EntityNotFoundException {
        // given
        final Item item = RandomFactory.createItem();
        when(itemRepository.findOne(anyLong())).thenReturn(item);

        // when
        itemRepositoryService.delete(item.getId());

        // then
        verify(itemRepository, times(1)).delete(Matchers.refEq(item));
    }

    @Test
    public void deleteEntityNotFoundException() throws EntityNotFoundException {
        thrown.expect(EntityNotFoundException.class);

        itemRepositoryService.delete(RandomUtils.nextLong(0, Long.MAX_VALUE));
    }

    @Test
    public void findAll() {
        // given
        final Item item = RandomFactory.createItem();
        final List<Item> items = new ArrayList<Item>();
        items.add(item);
        when(itemRepository.findAll()).thenReturn(items);

        // when
        final List<Item> itemsFound = itemRepositoryService.findAll();

        // then
        verify(itemRepository, times(1)).findAll();
        assertThat(itemsFound, sameInstance(items));
    }

    @Test
    public void findAllEmpty() {
        // given
        final List<Item> items = new ArrayList<Item>();
        when(itemRepository.findAll()).thenReturn(items);

        // when
        final List<Item> itemsFound = itemRepositoryService.findAll();

        // then
        verify(itemRepository, times(1)).findAll();
        assertThat(itemsFound, sameInstance(items));
    }

    @Test
    public void findById() throws EntityNotFoundException {
        // given
        final Item item = RandomFactory.createItem();
        when(itemRepository.findOne(anyLong())).thenReturn(item);

        // when
        final Item itemFound = itemRepositoryService.findById(item.getId());

        // then
        assertThat(itemFound, sameInstance(item));
        verify(itemRepository, times(1)).findOne(Matchers.refEq(item.getId()));
    }

    @Test
    public void findByIdEntityNotFoundException() throws EntityNotFoundException {
        thrown.expect(EntityNotFoundException.class);

        itemRepositoryService.findById(RandomUtils.nextLong(0, Long.MAX_VALUE));
    }

    @Test
    public void update() throws EntityNotFoundException {
        // given
        final Item item = RandomFactory.createItem();
        when(itemRepository.findOne(anyLong())).thenReturn(item);
        when(itemRepository.saveAndFlush(any(Item.class))).thenReturn(item);

        // when
        final Item updatedItem = itemRepositoryService.update(item);

        // then
        assertThat(updatedItem, sameInstance(item));
        verify(itemRepository, times(1)).saveAndFlush(Matchers.refEq(item));
    }

    @Test
    public void updateEntityNotFoundException() throws EntityNotFoundException {
        thrown.expect(EntityNotFoundException.class);

        final Item item = RandomFactory.createItem();
        itemRepositoryService.update(item);
    }
}
