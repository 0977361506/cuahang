package com.estore.services;

import java.util.List;

public interface reportDAO {
  public List<Object[]> inventory();
  public List<Object[]> thongketheoloaimh();
  public List<Object[]> thongketheokh();
  public List<Object[]> theonam();
  public List<Object[]> theoquy();
  public List<Object[]> theothang();

}
