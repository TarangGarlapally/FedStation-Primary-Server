package com.fedstation.FedStation.projection;

import com.fedstation.FedStation.entity.ModelType;
import com.fedstation.FedStation.entity.UserDetail;

public interface MarketplaceItemDetailProjection {
    
    String getId();

    ModelType getModelType();

    UserDetail getUser();

    String getMarketplaceItemName();

    String getMarketplaceItemDescription();

    String getMarketplaceItemContact();

}
