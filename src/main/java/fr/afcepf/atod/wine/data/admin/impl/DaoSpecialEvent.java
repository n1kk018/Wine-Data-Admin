package fr.afcepf.atod.wine.data.admin.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.afcepf.atod.wine.data.admin.api.IDaoSpecialEvent;
import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.entity.SpecialEvent;

@Service
@Transactional
public class DaoSpecialEvent extends DaoGeneric<SpecialEvent, Integer> implements IDaoSpecialEvent {

}
