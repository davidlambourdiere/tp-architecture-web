package com.lifetech.domain;

import com.lifetech.application.dto.*;
import com.lifetech.domain.model.*;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.JavassistCompilerStrategy;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.unenhance.HibernateUnenhanceStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrikaBeanMapper extends ConfigurableMapper {
    private MapperFactory factory;

    public OrikaBeanMapper() {
        super(false);
        init();
    }

    @Override
    protected void configure(MapperFactory factory) {
        this.factory = factory;
        registerClassMap(Person.class, PersonDTO.class);
        registerClassMap(Heater.class, HeaterDTO.class);
        registerClassMap(Light.class, LightDTO.class);
        registerClassMap(Shutter.class, ShutterDTO.class);
        registerClassMap(Clock.class, ClockDTO.class);
        registerClassMap(Strap.class, StrapDTO.class);
        registerClassMap(PersonProfile.class, PersonProfileDTO.class);
        registerClassMap(Subscription.class, SubscriptionDTO.class);
        registerClassMap(Room.class, RoomDTO.class);
        registerClassMap(AlertHealth.class, AlertHealthDTO.class);
        registerClassMap(ClockBreakdown.class, ClockBreakdownDTO.class);
        registerClassMap(LightBreakdown.class, LightBreakdownDTO.class);
        registerClassMap(HeaterBreakdown.class, HeaterBreakdownDTO.class);
        registerClassMap(StrapBreakdown.class, StrapBreakdownDTO.class);
        registerClassMap(HeaterMessage.class, HeaterMessageDTO.class);


    }

    private void registerClassMap(Class a, Class b) {
        this.factory.classMap(a, b).mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

    private void registerClassMap(Class a, Class b, String... excludeFields) {
        ClassMapBuilder builder = this.factory.classMap(a, b);
        for (String excludeField : excludeFields) {
            builder.exclude(excludeField);
        }
        builder.mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        factoryBuilder.compilerStrategy(new JavassistCompilerStrategy());
        factoryBuilder.unenhanceStrategy(new HibernateUnenhanceStrategy());
    }

    public <T, U> T convertDTO(U from, Class<T> toClass) {
        if (from == null) {
            return null;
        }
        return map(from, toClass);
    }

    public <T, U> List<T> convertListDTO(Iterable<U> from, Class<T> toClass) {
        if (from == null) {
            return null;
        }
        return mapAsList(from, toClass);
    }


}
