package ar.edu.unsam.phm.backendgrupo2.bootstrap

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ar.edu.unsam.phm.backendgrupo2.repository.*
import ar.edu.unsam.phm.backendgrupo2.domain.*
import java.time.LocalDateTime

@Service
class ApplicationBootstrap() : InitializingBean {

  @Autowired
  lateinit var roleRepository: RoleRepository

  @Autowired
  lateinit var userRepository: UserRepository

  @Autowired
  lateinit var seatTypeRepository: SeatTypeRepository

  @Autowired
  lateinit var functionShowRepository: FunctionShowRepository

  @Autowired
  lateinit var locationRepository: LocationRepository

  @Autowired
  lateinit var placeOfShowRepository: PlaceOfShowRepository

  @Autowired
  lateinit var statusShowRepository: StatusShowRepository

  @Autowired
  lateinit var showRepository: ShowRepository

  @Autowired
  lateinit var commentRepository: CommentRepository

  @Autowired
  lateinit var ticketRepository: TicketRepository

  // Roles
  val administrator: Role = Role()
  val consumer: Role = Role()

  // Users
  val joaquin: User = User()
  val henry: User = User()
  val scarlet: User = User()
  val megan: User = User()
  val adrian: User = User()

  // SeatTypes
  var seatTypePlateaAlta = SeatType()
  val seatTypeCampo = SeatType()
  val seatTypePalco = SeatType()

  var seatTypePlateaAltaJudasPriest = SeatType()
  val seatTypeCampoJudasPriest = SeatType()
  val seatTypePalcoJudasPriest = SeatType()

  val seatTypePullman = SeatType()
  val seatTypePlateaBaja = SeatType()

  val seatTypePullmanTwistedSister = SeatType()
  val seatTypePlateaBajaTwistedSister = SeatType()

  // Function show date
  val dateToFunctionShowAcdc1: LocalDateTime = LocalDateTime.of(2024,12,1,19,0,0)
  val dateToFunctionShowAcdc2: LocalDateTime = LocalDateTime.of(2024,12,2,20,0,0)
  val dateToFunctionShowAcdc3: LocalDateTime = LocalDateTime.of(2024,12,3,21,0,0)

  val dateToFunctionShowMegadeth1: LocalDateTime = LocalDateTime.of(2024,8,1,19,0,0)
  val dateToFunctionShowMegadeth2: LocalDateTime = LocalDateTime.of(2024,8,2,20,0,0)

  val dateToFunctionShowIronMaiden1: LocalDateTime = LocalDateTime.of(2024,9,1,19,0,0)
  val dateToFunctionShowIronMaiden2: LocalDateTime = LocalDateTime.of(2024,9,2,20,0,0)
  val dateToFunctionShowIronMaiden3: LocalDateTime = LocalDateTime.of(2024,9,3,21,0,0)

  val dateToFunctionShowJudasPriest1: LocalDateTime = LocalDateTime.of(2024,5,17,19,0,0)
  val dateToFunctionShowJudasPriest2: LocalDateTime = LocalDateTime.of(2024,5,18,20,0,0)

  val dateToFunctionShowTwistedSister1: LocalDateTime = LocalDateTime.of(2025,3,17,19,0,0)
  val dateToFunctionShowTwistedSister2: LocalDateTime = LocalDateTime.of(2025,2,18,20,0,0)

  val dateToFunctionShowMetallica1: LocalDateTime = LocalDateTime.of(2026,5,4,19,0,0)
  val dateToFunctionShowMetallica2: LocalDateTime = LocalDateTime.of(2026,5,5,20,0,0)

  val dateToFunctionShowLarenga1: LocalDateTime = LocalDateTime.of(2020,10,4,19,0,0)
  val dateToFunctionShowLarenga2: LocalDateTime = LocalDateTime.of(2020,10,5,20,0,0)

  val dateToFunctionShowHermetica1: LocalDateTime = LocalDateTime.of(2020,2,4,19,0,0)
  val dateToFunctionShowHermetica2: LocalDateTime = LocalDateTime.of(2020,2,5,20,0,0)

  // FunctionsShows
  val functionShowACDC1 = FunctionShow()
  val functionShowACDC2 = FunctionShow()
  val functionShowACDC3 = FunctionShow()

  val functionMegadeth1 = FunctionShow()
  val functionMegadeth2 = FunctionShow()

  val functionIronMaden1 = FunctionShow()
  val functionIronMaden2 = FunctionShow()
  val functionIronMaden3 = FunctionShow()

  val functionJudasPriest1 = FunctionShow()
  val functionJudasPriest2 = FunctionShow()

  val functionTwistedSister1 = FunctionShow()
  val functionTwistedSister2 = FunctionShow()

  val functionShowMetallica1 = FunctionShow()
  val functionShowMetallica2 = FunctionShow()

  val functionLaRenga1 = FunctionShow()
  val functionLaRenga2 = FunctionShow()

  val functionShowHermetica1 = FunctionShow()
  val functionShowHermetica2 = FunctionShow()

  // Location
  val riverPlateLocation = Location()
  val teatroColonLocation = Location()
  val estadioUnicoDeLaPlataLocation = Location()
  val estadioMovistarArenaLocation = Location()
  val teatroGranRexLocation = Location()
  val estadioVelezLocation = Location()
  val lunaParkLocation = Location()
  val teatroOperaLocation = Location()

  // Place of show
  val riverPlatePlaceOfShow = Stadium()
  val estadioUnicoDeLaPlataPlaceOfShow = Stadium()
  val estadioMovistarArenaPlaceOfShow = Stadium()
  val estadioVelezPlaceOfShow = Stadium()
  val lunaParkPlaceOfShow = Stadium()
  val teatroGranRexPlaceOfShow = Theater()
  val teatroOperaPlaceOfShow = Theater()
  val teatroColonPlaceOfShow = Theater()

  // Status Show
  val basePrice = StatusShow()
  val totalSale = StatusShow()
  val megashowSale  = StatusShow()

  // Shows
  val acdc: Show = Show()
  val megadeth: Show = Show()
  val ironMaiden: Show = Show()
  val judasPriest: Show = Show()
  val twistedSister: Show = Show()
  val metallica: Show = Show()
  val laRenga: Show = Show()
  val hermetica: Show = Show()

  // Comments
  val commentJoaquinAcdc = Comment()
  val commentJoaquinIronMaiden = Comment()
  val commentJoaquinMetallica = Comment()
  val commentJoaquinHermetica = Comment()
  val commentJoaquinLaRenga = Comment()

  val commentHenryMegadeth = Comment()
  val commentHenryAcdc = Comment()
  val commentHenryJudasPriest = Comment()
  val commentHenryTwistedSister = Comment()

  val commentMeganMetallica = Comment()
  val commentMeganHermetica = Comment()
  val commentMeganLaRenga = Comment()

  val commentAdrianMetallica = Comment()
  val commentAdrianHermetica = Comment()
  val commentAdrianLaRenga = Comment()

  // Ticket Types
  val ticketTypePlateaAlta = Ticket()
  val ticketTypeCampo = Ticket()
  val ticketTypePalco = Ticket()
  
  val ticketTypePlateaAltaJudasPriest = Ticket()
  val ticketTypeCampoJudasPriest = Ticket()
  val ticketTypePalcoJudasPriest = Ticket()
  
  val ticketTypePullman = Ticket()
  val ticketTypePlateaBaja = Ticket()
  
  val ticketTypePullmanTwistedSister = Ticket()
  val ticketTypePlateaBajaTwistedSister = Ticket()
  
  // Tickets
  val ticketAdrianAcdc = Ticket()
  val ticketAdrianIronMaiden = Ticket()
  val ticketAdrianMegadeth = Ticket()
  val ticketAdrianTwistedSister = Ticket()
  val ticketAdrianTwistedSister2 = Ticket()
  val ticketAdrianMetallica = Ticket()
  val ticketAdrianLaRenga = Ticket()
  val ticketAdrianHermetica = Ticket()

  val ticketJoaquinAcdc = Ticket()
  val ticketJoaquinIronMaiden = Ticket()
  val ticketJoaquinMetallica = Ticket()
  val ticketJoaquinLaRenga = Ticket()
  val ticketJoaquinHermetica = Ticket()

  val ticketHenryAcdc = Ticket()
  val ticketHenryJudasPriest = Ticket()
  val ticketHenryMegadeth = Ticket()
  val ticketHenryTwistedSister = Ticket()
  val ticketHenryTwistedSister2 = Ticket()
  val ticketHenryLaRenga = Ticket()

  val ticketMeganAcdc = Ticket()
  val ticketMeganIronMaiden = Ticket()
  val ticketMeganMetallica = Ticket()
  val ticketMeganJudasPriest = Ticket()
  val ticketMeganJudasPriest2 = Ticket()
  val ticketMeganHermetica = Ticket()
  val ticketMeganLaRenga = Ticket()

  val ticketScarletAcdc = Ticket()
  val ticketScarletIronMaiden = Ticket()
  val ticketScarletMetallica = Ticket()
  val ticketScarletJudasPriest = Ticket()

  override fun afterPropertiesSet() {
    
    // Roles
    administrator.apply {
      this.name = "Administrator"
      this.isAdministrator = true
    }
    consumer.apply {
      this.name = "Consumer"
      this.isAdministrator = false
    }
    
    this.roleRepository.saveAll(listOf(
      administrator, consumer
    ))
    
    // Location
    riverPlateLocation.apply {
      this.longitud = -58.449722222222
      this.latitud = -34.545277777778
    }
    teatroColonLocation.apply {
      this.longitud = -58.3831868989758
      this.latitud = -34.6010855
    }
    estadioUnicoDeLaPlataLocation.apply {
      this.longitud = -57.989028
      this.latitud = -34.91375
    }
    estadioMovistarArenaLocation.apply {
      this.longitud = -58.4480998824136
      this.latitud = -34.5943467
    }
    teatroGranRexLocation.apply {
      this.longitud = -58.4480998824136
      this.latitud = -34.5943467
    }
    estadioVelezLocation.apply {
      this.longitud = -58.4689
      this.latitud = -34.6378
    }
    lunaParkLocation.apply {
      this.longitud = -58.3707
      this.latitud = -34.5988
    }
    teatroOperaLocation.apply {
      this.longitud = -58.3922
      this.latitud = -34.6085
    }
    
    this.locationRepository.saveAll(listOf(
      riverPlateLocation, teatroColonLocation, estadioUnicoDeLaPlataLocation,
      estadioMovistarArenaLocation, teatroGranRexLocation, estadioVelezLocation,
      lunaParkLocation, teatroOperaLocation
    ))
    
    // SeatTypes
    seatTypePlateaAlta.apply {
      this.name = "Platea Alta"
      this.capacity = 5000
      this.costSeatType = 10000.0.toBigDecimal()
    }
    seatTypeCampo.apply {
      this.name = "Campo"
      this.capacity = 7000
      this.costSeatType = 15000.0.toBigDecimal()
    }
    seatTypePalco.apply {
      this.name = "Palco"
      this.capacity = 8000
      this.costSeatType = 20000.0.toBigDecimal()
    }
    
    seatTypePlateaAltaJudasPriest.apply {
      this.name = "Platea Alta"
      this.capacity = 1
      this.costSeatType = 10000.0.toBigDecimal()
    }
    seatTypeCampoJudasPriest.apply {
      this.name = "Campo"
      this.capacity = 1
      this.costSeatType = 15000.0.toBigDecimal()
    }
    seatTypePalcoJudasPriest.apply {
      this.name = "Palco"
      this.capacity = 1
      this.costSeatType = 20000.0.toBigDecimal()
    }
    
    seatTypePullman.apply {
      this.name = "Pullman"
      this.capacity = 6000
      this.costSeatType = 10000.0.toBigDecimal()
    }
    seatTypePlateaBaja.apply {
      this.name = "Platea Baja"
      this.capacity = 4000
      this.costSeatType = 15000.0.toBigDecimal()
    }
    
    seatTypePullmanTwistedSister.apply {
      this.name = "Pullman"
      this.capacity = 1
      this.costSeatType = 10000.0.toBigDecimal()
    }
    seatTypePlateaBajaTwistedSister.apply {
      this.name = "Platea Baja"
      this.capacity = 1
      this.costSeatType = 15000.0.toBigDecimal()
    }
    
    this.seatTypeRepository.saveAll(listOf(
      seatTypePlateaAlta, seatTypeCampo, seatTypePalco, seatTypePlateaAltaJudasPriest,
      seatTypeCampoJudasPriest, seatTypePalcoJudasPriest, seatTypePullman, seatTypePlateaBaja,
      seatTypePullmanTwistedSister, seatTypePlateaBajaTwistedSister
    ))
    
    // Status Show
    basePrice.apply {
      this.name = "Precio Base"
      this.profitStatusShowType = 1.8.toBigDecimal()
    }
    totalSale.apply {
      this.name = "Venta Plena"
      this.profitStatusShowType = 2.0.toBigDecimal()
    }
    megashowSale.apply {
      this.name = "venta Megashow"
      this.profitStatusShowType = 2.3.toBigDecimal()
    }
    
    this.statusShowRepository.saveAll(listOf(
      basePrice, totalSale, megashowSale
    ))
    
    // Ticket Types
    ticketTypePlateaAlta.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaAlta
    }
    ticketTypeCampo.apply {
      this.seatType = this@ApplicationBootstrap.seatTypeCampo
    }
    ticketTypePalco.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
    }
    
    ticketTypePlateaAltaJudasPriest.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaAltaJudasPriest
    }
    ticketTypeCampoJudasPriest.apply {
      this.seatType = this@ApplicationBootstrap.seatTypeCampoJudasPriest
    }
    ticketTypePalcoJudasPriest.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalcoJudasPriest
    }
    
    ticketTypePullman.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePullman
    }
    ticketTypePlateaBaja.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaBaja
    }
    
    ticketTypePullmanTwistedSister.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePullmanTwistedSister
    }
    ticketTypePlateaBajaTwistedSister.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaBajaTwistedSister
    }
    
    this.ticketRepository.saveAll(listOf(
      ticketTypePlateaAlta, ticketTypeCampo, ticketTypePalco, ticketTypePlateaAltaJudasPriest,
      ticketTypeCampoJudasPriest, ticketTypePalcoJudasPriest, ticketTypePullman, ticketTypePlateaBaja,
      ticketTypePullmanTwistedSister, ticketTypePlateaBajaTwistedSister
    ))
    
    // Place Of Shows
    riverPlatePlaceOfShow.apply {
      this.name = "Estadio River Plate"
      this.type = "Stadium"
      this.mapLocation = this@ApplicationBootstrap.riverPlateLocation
      this.fixedCost = 80000.toBigDecimal()
      this.ticketsTypeList = mutableListOf(
        ticketTypePlateaAlta, ticketTypeCampo, ticketTypePalco
      )
    }
    estadioUnicoDeLaPlataPlaceOfShow.apply {
      this.name = "Estadio único Diego"
      this.type = "Stadium"
      this.mapLocation = this@ApplicationBootstrap.estadioUnicoDeLaPlataLocation
      this.fixedCost = 5430000.toBigDecimal()
      this.ticketsTypeList = mutableListOf(
        ticketTypePlateaAlta, ticketTypeCampo, ticketTypePalco
      )
    }
    estadioMovistarArenaPlaceOfShow.apply {
      this.name = "Movistar Arena"
      this.type = "Stadium"
      this.mapLocation = this@ApplicationBootstrap.estadioMovistarArenaLocation
      this.fixedCost = 200000.toBigDecimal()
      this.ticketsTypeList = mutableListOf(
        ticketTypePlateaAltaJudasPriest, ticketTypeCampoJudasPriest, ticketTypePalcoJudasPriest
      )
    }
    estadioVelezPlaceOfShow.apply {
      this.name = "Estadio Velez"
      this.type = "Stadium"
      this.mapLocation = this@ApplicationBootstrap.estadioVelezLocation
      this.fixedCost = 253000.toBigDecimal()
      this.ticketsTypeList = mutableListOf(
        ticketTypePlateaAlta, ticketTypeCampo, ticketTypePalco
      )
    }
    lunaParkPlaceOfShow.apply {
      this.name = "Luna Park"
      this.type = "Stadium"
      this.mapLocation = this@ApplicationBootstrap.lunaParkLocation
      this.fixedCost = 180000.toBigDecimal()
      this.ticketsTypeList = mutableListOf(
        ticketTypePlateaAlta, ticketTypeCampo, ticketTypePalco
      )
    }
    teatroColonPlaceOfShow.apply {
      this.name = "Teatro Gran Rex"
      this.type = "Theater"
      this.mapLocation = this@ApplicationBootstrap.teatroGranRexLocation
      this.fixedCost = 100000.toBigDecimal()
      this.hasGoodAcoustic = true
      this.ticketsTypeList = mutableListOf(
        ticketTypePullman, ticketTypePlateaBaja
      )
    }
    teatroOperaPlaceOfShow.apply {
      this.name = "Teatro Opera"
      this.type = "Theater"
      this.mapLocation = this@ApplicationBootstrap.teatroOperaLocation
      this.fixedCost = 100000.toBigDecimal()
      this.hasGoodAcoustic = true
      this.ticketsTypeList = mutableListOf(
        ticketTypePullman, ticketTypePlateaBaja
      )
    }
    teatroGranRexPlaceOfShow.apply {
      this.name = "Teatro Colon"
      this.type = "Theater"
      this.mapLocation = this@ApplicationBootstrap.teatroColonLocation
      this.fixedCost = 100000.toBigDecimal()
      this.hasGoodAcoustic = true
      this.ticketsTypeList = mutableListOf(
        ticketTypePullmanTwistedSister, ticketTypePlateaBajaTwistedSister
      )
    }
    
    this.placeOfShowRepository.saveAll(listOf(
      riverPlatePlaceOfShow, estadioUnicoDeLaPlataPlaceOfShow, estadioMovistarArenaPlaceOfShow,
      estadioVelezPlaceOfShow, lunaParkPlaceOfShow, teatroGranRexPlaceOfShow,
      teatroOperaPlaceOfShow, teatroColonPlaceOfShow
    ))
    
    // Shows
    acdc.apply {
      this.bandName = "AC-DC"
      this.placeOfShow = this@ApplicationBootstrap.riverPlatePlaceOfShow
      this.nameOfRecital = "Power up Tour"
      this.costBand = 2400000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/acdc.jpg"
    }
    megadeth.apply {
      this.bandName = "Megadeth"
      this.placeOfShow = this@ApplicationBootstrap.teatroColonPlaceOfShow
      this.nameOfRecital = "Movistar Arena Tour"
      this.costBand = 180000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/megadeth.jpg"
    }
    ironMaiden.apply {
      this.bandName = "Iron Maiden"
      this.placeOfShow = this@ApplicationBootstrap.estadioUnicoDeLaPlataPlaceOfShow
      this.nameOfRecital = "Fear of the dark"
      this.costBand = 4500000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/iron-maiden.jpg"
    }
    judasPriest.apply {
      this.bandName = "Judas Priest"
      this.placeOfShow = this@ApplicationBootstrap.estadioMovistarArenaPlaceOfShow
      this.nameOfRecital = "Firepower"
      this.costBand = 600000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/juda-priest.jpg"
    }
    twistedSister.apply {
      this.bandName = "Twisted Sister"
      this.placeOfShow = this@ApplicationBootstrap.teatroGranRexPlaceOfShow
      this.nameOfRecital = "Taken"
      this.costBand = 30000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/twisted-sister.jpg"
    }
    metallica.apply {
      this.bandName = "Metallica"
      this.placeOfShow = this@ApplicationBootstrap.estadioVelezPlaceOfShow
      this.nameOfRecital = "Through the never"
      this.costBand = 100000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/metallica.png"
    }
    laRenga.apply {
      this.bandName = "La Renga"
      this.placeOfShow = this@ApplicationBootstrap.lunaParkPlaceOfShow
      this.nameOfRecital = "Cosquin"
      this.costBand = 100000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/la-renga.jpg"
    }
    hermetica.apply {
      this.bandName = "Hermética"
      this.placeOfShow = this@ApplicationBootstrap.teatroOperaPlaceOfShow
      this.nameOfRecital = "La H no murió"
      this.costBand = 100000.00.toBigDecimal()
      this.status = this@ApplicationBootstrap.basePrice
      this.image = "assets/hermetica.jpg"
    }
    
    this.showRepository.saveAll(listOf(
      acdc, ironMaiden, megadeth, metallica,
      judasPriest, twistedSister, laRenga, hermetica
    ))
    
    // FunctionsShows
    functionShowACDC1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowAcdc1
      this.show = this@ApplicationBootstrap.acdc
    }
    functionShowACDC2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowAcdc2
      this.show = this@ApplicationBootstrap.acdc
    }
    functionShowACDC3.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowAcdc3
      this.show = this@ApplicationBootstrap.acdc
    }
    functionMegadeth1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowMegadeth1
      this.show = this@ApplicationBootstrap.megadeth
    }
    functionMegadeth2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowMegadeth2
      this.show = this@ApplicationBootstrap.megadeth
    }
    functionIronMaden1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowIronMaiden1
      this.show = this@ApplicationBootstrap.ironMaiden
    }
    functionIronMaden2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowIronMaiden2
      this.show = this@ApplicationBootstrap.ironMaiden
    }
    functionIronMaden3.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowIronMaiden3
      this.show = this@ApplicationBootstrap.ironMaiden
    }
    functionJudasPriest1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowJudasPriest1
      this.show = this@ApplicationBootstrap.judasPriest
    }
    functionJudasPriest2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowJudasPriest2
      this.show = this@ApplicationBootstrap.judasPriest
    }
    functionTwistedSister1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowTwistedSister1
      this.show = this@ApplicationBootstrap.twistedSister
    }
    functionTwistedSister2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowTwistedSister2
      this.show = this@ApplicationBootstrap.twistedSister
    }
    functionShowMetallica1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowMetallica1
      this.show = this@ApplicationBootstrap.metallica
    }
    functionShowMetallica2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowMetallica2
      this.show = this@ApplicationBootstrap.metallica
    }
    functionLaRenga1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowLarenga1
      this.show = this@ApplicationBootstrap.laRenga
    }
    functionLaRenga2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowLarenga2
      this.show = this@ApplicationBootstrap.laRenga
    }
    functionShowHermetica1.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowHermetica1
      this.show = this@ApplicationBootstrap.hermetica
    }
    functionShowHermetica2.apply {
      this.hourOfFunction = this@ApplicationBootstrap.dateToFunctionShowHermetica2
      this.show = this@ApplicationBootstrap.hermetica
    }
    
    this.functionShowRepository.saveAll(listOf(
      functionShowACDC1, functionShowACDC2, functionShowACDC3, functionMegadeth1,
      functionMegadeth2, functionIronMaden1, functionIronMaden2, functionIronMaden3,
      functionJudasPriest1, functionJudasPriest2, functionTwistedSister1, functionTwistedSister2,
      functionShowMetallica1, functionShowMetallica2, functionLaRenga1, functionLaRenga2,
      functionShowHermetica1, functionShowHermetica2
    ))
    
    // Ticket Types
    ticketTypePlateaAlta.apply {
      this.functionShow = this@ApplicationBootstrap.functionShowACDC1
    }
    ticketTypeCampo.apply {
      this.functionShow = this@ApplicationBootstrap.functionShowACDC1
    }
    ticketTypePalco.apply {
      this.functionShow = this@ApplicationBootstrap.functionShowACDC1
    }
    
    ticketTypePlateaAltaJudasPriest.apply {
      this.functionShow = this@ApplicationBootstrap.functionJudasPriest1
    }
    ticketTypeCampoJudasPriest.apply {
      this.functionShow = this@ApplicationBootstrap.functionJudasPriest1
    }
    ticketTypePalcoJudasPriest.apply {
      this.functionShow = this@ApplicationBootstrap.functionJudasPriest1
    }
    
    ticketTypePullman.apply {
      this.functionShow = this@ApplicationBootstrap.functionShowACDC1
    }
    ticketTypePlateaBaja.apply {
      this.functionShow = this@ApplicationBootstrap.functionShowACDC1
    }
    
    ticketTypePullmanTwistedSister.apply {
      this.functionShow = this@ApplicationBootstrap.functionTwistedSister1
    }
    ticketTypePlateaBajaTwistedSister.apply {
      this.functionShow = this@ApplicationBootstrap.functionTwistedSister1
    }
    
    this.ticketRepository.saveAll(listOf(
      ticketTypePlateaAlta, ticketTypeCampo, ticketTypePalco, ticketTypePlateaAltaJudasPriest,
      ticketTypeCampoJudasPriest, ticketTypePalcoJudasPriest, ticketTypePullman, ticketTypePlateaBaja,
      ticketTypePullmanTwistedSister, ticketTypePlateaBajaTwistedSister
    ))
    
    // Tickets
    ticketAdrianAcdc.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaAlta
      this.functionShow = this@ApplicationBootstrap.functionShowACDC1
    }
    ticketAdrianIronMaiden.apply {
      this.seatType = this@ApplicationBootstrap.seatTypeCampo
      this.functionShow = this@ApplicationBootstrap.functionIronMaden1
    }
    ticketAdrianMegadeth.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionMegadeth1
    }
    ticketAdrianTwistedSister.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePullman
      this.functionShow = this@ApplicationBootstrap.functionTwistedSister1
    }
    ticketAdrianTwistedSister2.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaBaja
      this.functionShow = this@ApplicationBootstrap.functionTwistedSister1
    }
    ticketAdrianMetallica.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionShowMetallica1
    }
    ticketAdrianLaRenga.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionLaRenga1
    }
    ticketAdrianHermetica.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionShowHermetica1
    }
    
    ticketJoaquinAcdc.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaAlta
      this.functionShow = this@ApplicationBootstrap.functionShowACDC2
    }
    ticketJoaquinIronMaiden.apply {
      this.seatType = this@ApplicationBootstrap.seatTypeCampo
      this.functionShow = this@ApplicationBootstrap.functionIronMaden2
    }
    ticketJoaquinMetallica.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionShowMetallica2
    }
    ticketJoaquinLaRenga.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionLaRenga2
    }
    ticketJoaquinHermetica.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionShowHermetica2
    }
    
    ticketHenryAcdc.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaAlta
      this.functionShow = this@ApplicationBootstrap.functionShowACDC3
    }
    ticketHenryJudasPriest.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaAlta
      this.functionShow = this@ApplicationBootstrap.functionJudasPriest1
    }
    ticketHenryMegadeth.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionMegadeth2
    }
    ticketHenryTwistedSister.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePullman
      this.functionShow = this@ApplicationBootstrap.functionTwistedSister2
    }
    ticketHenryTwistedSister2.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaBaja
      this.functionShow = this@ApplicationBootstrap.functionTwistedSister2
    }
    ticketHenryLaRenga.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionLaRenga2
    }
    
    ticketMeganAcdc.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePlateaAlta
      this.functionShow = this@ApplicationBootstrap.functionShowACDC3
    }
    ticketMeganIronMaiden.apply {
      this.seatType = this@ApplicationBootstrap.seatTypeCampo
      this.functionShow = this@ApplicationBootstrap.functionIronMaden3
    }
    ticketMeganMetallica.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionShowMetallica2
    }
    ticketMeganJudasPriest.apply {
      this.seatType = this@ApplicationBootstrap.seatTypeCampo
      this.functionShow = this@ApplicationBootstrap.functionJudasPriest2
    }
    ticketMeganJudasPriest2.apply {
      this.seatType = this@ApplicationBootstrap.seatTypeCampo
      this.functionShow = this@ApplicationBootstrap.functionJudasPriest2
    }
    ticketMeganHermetica.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionShowHermetica2
    }
    ticketMeganLaRenga.apply {
      this.seatType = this@ApplicationBootstrap.seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionLaRenga1
    }
    
    ticketScarletAcdc.apply {
      this.seatType = seatTypePlateaAlta
      this.functionShow = this@ApplicationBootstrap.functionShowACDC3
    }
    ticketScarletIronMaiden.apply {
      this.seatType = seatTypeCampo
      this.functionShow = this@ApplicationBootstrap.functionIronMaden3
    }
    ticketScarletMetallica.apply {
      this.seatType = seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionShowMetallica2
    }
    ticketScarletJudasPriest.apply {
      this.seatType = seatTypePalco
      this.functionShow = this@ApplicationBootstrap.functionJudasPriest1
    }
    
    this.ticketRepository.saveAll(listOf(
      ticketAdrianAcdc, ticketAdrianIronMaiden, ticketAdrianMegadeth, ticketAdrianTwistedSister,
      ticketAdrianTwistedSister2, ticketAdrianMetallica, ticketAdrianLaRenga, ticketAdrianHermetica,
      ticketJoaquinAcdc, ticketJoaquinIronMaiden, ticketJoaquinMetallica, ticketJoaquinLaRenga,
      ticketJoaquinHermetica, ticketHenryAcdc, ticketHenryJudasPriest, ticketHenryMegadeth,
      ticketHenryTwistedSister, ticketHenryTwistedSister2, ticketHenryLaRenga, ticketMeganAcdc,
      ticketMeganIronMaiden, ticketMeganMetallica, ticketMeganJudasPriest, ticketMeganJudasPriest2,
      ticketMeganHermetica, ticketMeganLaRenga, ticketScarletAcdc, ticketScarletIronMaiden, ticketScarletMetallica,
      ticketScarletJudasPriest
    ))
    
    // FunctionsShows
    functionShowACDC1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketAdrianAcdc
      ))
    }
    functionShowACDC2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketJoaquinAcdc
      ))
    }
    functionShowACDC3.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketHenryAcdc, ticketMeganAcdc, ticketScarletAcdc
      ))
    }
    functionMegadeth1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketAdrianMegadeth
      ))
    }
    functionMegadeth2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketHenryMegadeth
      ))
    }
    functionIronMaden1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketAdrianIronMaiden
      ))
    }
    functionIronMaden2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketJoaquinIronMaiden
      ))
    }
    functionIronMaden3.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketMeganIronMaiden, ticketScarletIronMaiden
      ))
    }
    functionJudasPriest1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketHenryJudasPriest, ticketMeganJudasPriest, ticketScarletJudasPriest
      ))
    }
    functionJudasPriest2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketMeganJudasPriest2
      ))
    }
    functionTwistedSister1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketAdrianTwistedSister, ticketAdrianTwistedSister2
      ))
    }
    functionTwistedSister2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketHenryTwistedSister, ticketHenryTwistedSister2
      ))
    }
    functionShowMetallica1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketAdrianMetallica
      ))
    }
    functionShowMetallica2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketJoaquinMetallica, ticketMeganMetallica, ticketScarletMetallica
      ))
    }
    functionLaRenga1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketAdrianLaRenga, ticketMeganLaRenga
      ))
    }
    functionLaRenga2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketJoaquinLaRenga, ticketHenryLaRenga
      ))
    }
    functionShowHermetica1.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketAdrianHermetica
      ))
    }
    functionShowHermetica2.apply {
      this.addTicketsToFunction(mutableListOf(
        ticketJoaquinHermetica, ticketMeganHermetica
      ))
    }
    
    this.functionShowRepository.saveAll(listOf(
      functionShowACDC1, functionShowACDC2, functionShowACDC3, functionMegadeth1,
      functionMegadeth2, functionIronMaden1, functionIronMaden2, functionIronMaden3,
      functionJudasPriest1, functionJudasPriest2, functionTwistedSister1, functionTwistedSister2,
      functionShowMetallica1, functionShowMetallica2, functionLaRenga1, functionLaRenga2,
      functionShowHermetica1, functionShowHermetica2
    ))
    
    // Users
    adrian.apply {
      this.name = "Joaquin"
      this.surname = "Phoenix"
      this.username = "Joaquin9120"
      this.imageUrl = "assets/Joaquin.jfif"
      this.country = "México"
      this.birthOfDate = LocalDateTime.of(1976, 3, 15, 0, 0, 0)
      this.dni = 30249358
      this.password = 11111
      this.availableMoney = 301.1.toBigDecimal()
      this.role = this@ApplicationBootstrap.consumer
      this.setFriends(mutableListOf(
        joaquin, henry, scarlet, megan
      ))
      this.setTickets(mutableListOf(
        ticketAdrianAcdc, ticketAdrianIronMaiden, ticketAdrianMegadeth,
        ticketAdrianTwistedSister, ticketAdrianTwistedSister2, ticketAdrianMetallica,
        ticketAdrianLaRenga, ticketAdrianHermetica
      ))
    }
    joaquin.apply {
      this.name = "Henry"
      this.surname = "Cavill"
      this.username = "Henry9910"
      this.imageUrl = "assets/henry.jfif"
      this.country = "USA"
      this.birthOfDate = LocalDateTime.of(1983, 2, 25, 0, 0, 0)
      this.dni = 90430596
      this.password = 54321
      this.availableMoney = 12000.1.toBigDecimal()
      this.role = this@ApplicationBootstrap.administrator
      this.setTickets(mutableListOf(
        ticketJoaquinAcdc, ticketJoaquinIronMaiden, ticketJoaquinMetallica,
        ticketJoaquinLaRenga, ticketJoaquinHermetica
      ))
    }
    henry.apply {
      this.name = "Scarlet"
      this.surname = "Johanson"
      this.username = "Johan2398"
      this.imageUrl = "assets/scarlet.jfif"
      this.country = "Perú"
      this.birthOfDate = LocalDateTime.of(1987, 3, 18, 0, 0, 0)
      this.dni = 9234543
      this.password = 55555
      this.availableMoney = 900.1.toBigDecimal()
      this.role = this@ApplicationBootstrap.consumer
      this.setTickets(mutableListOf(
        ticketHenryAcdc, ticketHenryJudasPriest, ticketHenryMegadeth,
        ticketHenryTwistedSister, ticketHenryTwistedSister2, ticketHenryLaRenga
      ))
    }
    megan.apply {
      this.name = "Megan"
      this.surname = "Fox"
      this.username = "Megan2398"
      this.imageUrl = "assets/megan.jfif"
      this.country = "Brasil"
      this.birthOfDate = LocalDateTime.of(1992, 12, 29, 0, 0, 0)
      this.dni = 65834239
      this.password = 44444
      this.availableMoney = 760.1.toBigDecimal()
      this.role = this@ApplicationBootstrap.consumer
      this.setTickets(mutableListOf(
        ticketMeganAcdc, ticketMeganIronMaiden, ticketMeganMetallica,
        ticketMeganJudasPriest, ticketMeganJudasPriest2, ticketMeganHermetica,
        ticketMeganLaRenga
      ))
    }
    scarlet.apply {
      this.name = "Adrian"
      this.surname = "Ibarra"
      this.username = "adrian9730"
      this.imageUrl = "assets/adrian.jpg"
      this.country = "Argentina"
      this.birthOfDate = LocalDateTime.of(1997, 3, 30, 0, 0, 0)
      this.dni = 232468359
      this.password = 12345
      this.availableMoney = 1710.1.toBigDecimal()
      this.role = this@ApplicationBootstrap.consumer
      this.setTickets(mutableListOf(
        ticketScarletAcdc, ticketScarletIronMaiden,
        ticketScarletMetallica, ticketScarletJudasPriest
      ))
    }
    
    this.userRepository.saveAll(listOf(
      adrian, joaquin, scarlet, henry, megan
    ))
    
    // Comments
    commentJoaquinAcdc.apply {
      this.description = "The show was incredible!"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 25, 0, 0, 0)
      this.show = this@ApplicationBootstrap.acdc
      this.owner = this@ApplicationBootstrap.joaquin
    }
    commentJoaquinIronMaiden.apply {
      this.description = "The show was horrible!"
      this.score = 1
      this.dateComment = LocalDateTime.of(2024, 11, 25, 0, 0, 0)
      this.show = this@ApplicationBootstrap.ironMaiden
      this.owner = this@ApplicationBootstrap.joaquin
    }
    commentJoaquinMetallica.apply {
      this.description = "The show was incredible!"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 24, 0, 0, 0)
      this.show = this@ApplicationBootstrap.metallica
      this.owner = this@ApplicationBootstrap.joaquin
    }
    commentJoaquinHermetica.apply {
      this.description = "The show was incredible!"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 25, 0, 0, 0)
      this.show = this@ApplicationBootstrap.hermetica
      this.owner = this@ApplicationBootstrap.joaquin
    }
    commentJoaquinLaRenga.apply {
      this.description = "The show was incredible!"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 25, 0, 0, 0)
      this.show = this@ApplicationBootstrap.laRenga
      this.owner = this@ApplicationBootstrap.joaquin
    }
    
    commentHenryMegadeth.apply {
      this.description = "The show was incredible!"
      this.score = 3
      this.dateComment = LocalDateTime.of(2024, 4, 16, 0, 0, 0)
      this.show = this@ApplicationBootstrap.megadeth
      this.owner = this@ApplicationBootstrap.henry
    }
    commentHenryAcdc.apply {
      this.description = "The show was incredible!"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 26, 0, 0, 0)
      this.show = this@ApplicationBootstrap.acdc
      this.owner = this@ApplicationBootstrap.henry
    }
    commentHenryJudasPriest.apply {
      this.description = "The show was fantastic!"
      this.score = 4
      this.dateComment = LocalDateTime.of(2024, 11, 30, 0, 0, 0)
      this.show = this@ApplicationBootstrap.judasPriest
      this.owner = this@ApplicationBootstrap.henry
    }
    commentHenryTwistedSister.apply {
      this.description = "The show had bad sounds!"
      this.score = 2
      this.dateComment = LocalDateTime.of(2024, 11, 25, 0, 0, 0)
      this.show = this@ApplicationBootstrap.twistedSister
      this.owner = this@ApplicationBootstrap.henry
    }
    
    commentMeganMetallica.apply {
      this.description = "The music was so beatiful"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 24, 0, 0, 0)
      this.show = this@ApplicationBootstrap.metallica
      this.owner = this@ApplicationBootstrap.megan
    }
    commentMeganHermetica.apply {
      this.description = "The show was perfect!"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 24, 0, 0, 0)
      this.show = this@ApplicationBootstrap.hermetica
      this.owner = this@ApplicationBootstrap.megan
    }
    commentMeganLaRenga.apply {
      this.description = "The show wasn't fun"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 25, 0, 0, 0)
      this.show = this@ApplicationBootstrap.laRenga
      this.owner = this@ApplicationBootstrap.megan
    }
    
    commentAdrianMetallica.apply {
      this.description = "The music was so beatiful"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 24, 0, 0, 0)
      this.show = this@ApplicationBootstrap.metallica
      this.owner = this@ApplicationBootstrap.adrian
    }
    commentAdrianHermetica.apply {
      this.description = "The show was perfect!"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 24, 0, 0, 0)
      this.show = this@ApplicationBootstrap.hermetica
      this.owner = this@ApplicationBootstrap.adrian
    }
    commentAdrianLaRenga.apply {
      this.description = "The show wasn't fun"
      this.score = 5
      this.dateComment = LocalDateTime.of(2024, 11, 25, 0, 0, 0)
      this.show = this@ApplicationBootstrap.laRenga
      this.owner = this@ApplicationBootstrap.adrian
    }

    this.commentRepository.saveAll(listOf(
      commentJoaquinAcdc, commentJoaquinIronMaiden, commentJoaquinMetallica, commentJoaquinHermetica,
      commentJoaquinLaRenga, commentHenryMegadeth, commentHenryAcdc, commentHenryJudasPriest,
      commentHenryTwistedSister, commentMeganMetallica, commentMeganHermetica, commentMeganLaRenga,
      commentAdrianMetallica, commentAdrianHermetica, commentAdrianLaRenga
    ))
    
    // Shows
    acdc.apply {
      this.addCommentsToShow(mutableListOf(
        commentJoaquinAcdc, commentHenryAcdc
      ))
      this.addFunctionsToShow(mutableListOf(
        functionShowACDC1, functionShowACDC2, functionShowACDC3
      ))
    }
    megadeth.apply {
      this.addCommentsToShow(mutableListOf(
        commentHenryMegadeth
      ))
      this.addFunctionsToShow(mutableListOf(
        functionMegadeth1, functionMegadeth2
      ))
    }
    ironMaiden.apply {
      this.addCommentsToShow(mutableListOf(
        commentJoaquinIronMaiden
      ))
      this.addFunctionsToShow(mutableListOf(
        functionIronMaden1, functionIronMaden2, functionIronMaden3
      ))
    }
    judasPriest.apply {
      this.addCommentsToShow(mutableListOf(
        commentHenryJudasPriest
      ))
      this.addFunctionsToShow(mutableListOf(
        functionJudasPriest1, functionJudasPriest2
      ))
    }
    twistedSister.apply {
      this.addCommentsToShow(mutableListOf(
        commentHenryTwistedSister
      ))
      this.addFunctionsToShow(mutableListOf(
        functionTwistedSister1, functionTwistedSister2
      ))
    }
    metallica.apply {
      this.addCommentsToShow(mutableListOf(
        commentAdrianMetallica, commentMeganMetallica, commentJoaquinMetallica
      ))
      this.addFunctionsToShow(mutableListOf(
        functionShowMetallica1, functionShowMetallica2
      ))
    }
    laRenga.apply {
      this.addCommentsToShow(mutableListOf(
        commentMeganLaRenga, commentAdrianLaRenga, commentJoaquinLaRenga
      ))
      this.addFunctionsToShow(mutableListOf(
        functionLaRenga1, functionLaRenga2
      ))
    }
    hermetica.apply {
      this.addCommentsToShow(mutableListOf(
        commentAdrianHermetica, commentJoaquinHermetica, commentMeganHermetica
      ))
      this.addFunctionsToShow(mutableListOf(
        functionShowHermetica1, functionShowHermetica2
      ))
    }
    
    this.showRepository.saveAll(listOf(
      acdc, ironMaiden, megadeth, metallica,
      judasPriest, twistedSister, laRenga, hermetica
    ))
  }
}