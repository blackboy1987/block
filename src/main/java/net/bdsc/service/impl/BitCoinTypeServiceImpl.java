
package net.bdsc.service.impl;

import net.bdsc.dao.BitCoinTypeDao;
import net.bdsc.entity.BitCoinType;
import net.bdsc.service.BitCoinTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service - 广告
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class BitCoinTypeServiceImpl extends BaseServiceImpl<BitCoinType, Long> implements BitCoinTypeService {

	@Autowired
	private BitCoinTypeDao bitCoinTypeDao;

	@Override
	public BitCoinType findByName(String name) {
		return bitCoinTypeDao.find("name",name);
	}
}