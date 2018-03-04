package mr.nyanko.playscala.models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = User.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table User
   *  @param id Database column id SqlType(INT), AutoInc
   *  @param name Database column name SqlType(VARCHAR), Length(200,true)
   *  @param remark Database column remark SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param updateTime Database column update_time SqlType(DATETIME)
   *  @param isDeleted Database column is_deleted SqlType(BIT), Default(false) */
  case class UserRow(id: Int, name: String, remark: Option[String] = None, createTime: java.sql.Timestamp, updateTime: java.sql.Timestamp, isDeleted: Boolean = false)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp], e4: GR[Boolean]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Boolean]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, Some("playscala"), "user") {
    def * = (id, name, remark, createTime, updateTime, isDeleted) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), remark, Rep.Some(createTime), Rep.Some(updateTime), Rep.Some(isDeleted)).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc */
    val id: Rep[Int] = column[Int]("id", O.AutoInc)
    /** Database column name SqlType(VARCHAR), Length(200,true) */
    val name: Rep[String] = column[String]("name", O.Length(200,varying=true))
    /** Database column remark SqlType(VARCHAR), Length(200,true), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("remark", O.Length(200,varying=true), O.Default(None))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column update_time SqlType(DATETIME) */
    val updateTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_time")
    /** Database column is_deleted SqlType(BIT), Default(false) */
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))

    /** Primary key of User (database name user_PK) */
    val pk = primaryKey("user_PK", (id, createTime))
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
