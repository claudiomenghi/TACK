G_e+ 0 ( ! 
        (&& 
            ( || 
                (ST1_station_z_sync)
                (|| 
                    (ST1_station_z_async)
                    (|| 
                        (ST1_station_y_sync) 
                        (ST1_station_y_async)
                    )
                )
            )  	
            (||
                (||
                    (ST2.station_z_sync) 
                    (ST2.station_z_async)
                )
                (||
                    (ST2.station_y_sync)
                    (ST2.station_y_async) 
                )
            )
        )
    )