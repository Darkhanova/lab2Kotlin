import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.swing.*
import javax.swing.table.AbstractTableModel


val frame = JFrame("MyApp")
val contentPanel = JPanel()
val buttonPanel = JPanel()
val imageLabel = JLabel(ImageIcon("images/logo.jpg"))
val clients = JButton("Список клиентов")
val hotel = JButton("Бронь отеля")
val flight = JButton("Бронь самолета")
val train = JButton("Бронь поезда")

val clientList = DefaultListModel<Client>()
val hotelList = DefaultListModel<Hotel>()
val flightList = DefaultListModel<Flight>()
val trainList = DefaultListModel<Train>()



fun main() {
    mainFrame()
}

class CancelButton : ActionListener {
    override fun actionPerformed(e: ActionEvent) {
        mainFrame()
    }
}

class HotelButton : ActionListener {
    override fun actionPerformed(e: ActionEvent) {
        //Удаление компонентов на панели
        contentPanel.removeAll()
        buttonPanel.removeAll()

        //Создание новых
        val nameClientField = JTextField(30)
        val nameClientInfo = JLabel(":Имя Клиента")

        val nameHotelField = JTextField(30)
        val nameHotelInfo = JLabel(":Название Отеля")

        val dateStartInfo = JLabel(":Дата начала")
        val dateStart = JTextField(30)

        val dateEndInfo = JLabel(":Дата конца")
        val dateEnd = JTextField(30)

        val book = JButton("Бронировать")
        val cancel = JButton("Отмена")




        //Занесение в панели
        contentPanel.layout = FlowLayout(FlowLayout.LEFT)
        contentPanel.add(nameClientField)
        contentPanel.add(nameClientInfo)

        contentPanel.add(nameHotelField)
        contentPanel.add(nameHotelInfo)
        contentPanel.add(dateStart)
        contentPanel.add(dateStartInfo)
        contentPanel.add(dateEnd)
        contentPanel.add(dateEndInfo)

        buttonPanel.add(book)
        buttonPanel.add(cancel)

        contentPanel.updateUI()
        buttonPanel.updateUI()

        //Дейтсвия на кнопки
        cancel.addActionListener(CancelButton())
        book.addActionListener {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            var dateS: LocalDate = LocalDate.parse("11.11.1111", formatter)
            var dateE: LocalDate = LocalDate.parse("11.11.1111", formatter)
            var client: Client? = null
            try {
                dateS = LocalDate.parse(dateStart.getText(), formatter)
                dateE = LocalDate.parse(dateEnd.getText(), formatter)
                if(!nameClientField.text.isEmpty())
                    client = Client(nameClientField.getText())
            }catch (e: Exception){
                JOptionPane.showMessageDialog(null,"Ошибка")
            }
            val nullDate = LocalDate.of(1111, 11, 11)
            if(client == null || dateE == nullDate || dateS == nullDate
                || nameHotelField.text.isEmpty() || dateS > dateE){
                JOptionPane.showMessageDialog(null,"Ошибка")
            }else {
                clientList.addElement(client)
                hotelList.addElement(Hotel(nameHotelField.getText(), dateS, dateE, client))
                JOptionPane.showMessageDialog(null,"Успешно")
                mainFrame()
            }
        }
    }
}

class FlightButton : ActionListener {
    override fun actionPerformed(e: ActionEvent) {
        //Удаление компонентов на панели
        contentPanel.removeAll()
        buttonPanel.removeAll()

        //Создание новых
        val nameClientField = JTextField(30)
        val nameClientInfo = JLabel(":Имя Клиента")

        val cityField = JTextField(30)
        val cityInfo = JLabel(":Город")

        val dateStartInfo = JLabel(":Дата отлета")
        val dateStart = JTextField(30)

        val dateEndInfo = JLabel(":Дата прилета")
        val dateEnd = JTextField(30)

        val book = JButton("Бронировать")
        val cancel = JButton("Отмена")




        //Занесение в панели
        contentPanel.layout = FlowLayout(FlowLayout.LEFT)
        contentPanel.add(nameClientField)
        contentPanel.add(nameClientInfo)

        contentPanel.add(cityField)
        contentPanel.add(cityInfo)
        contentPanel.add(dateStart)
        contentPanel.add(dateStartInfo)
        contentPanel.add(dateEnd)
        contentPanel.add(dateEndInfo)

        buttonPanel.add(book)
        buttonPanel.add(cancel)

        contentPanel.updateUI()
        buttonPanel.updateUI()

        //Дейтсвия на кнопки
        cancel.addActionListener(CancelButton())
        book.addActionListener {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            var dateS: LocalDate = LocalDate.parse("11.11.1111 00:00", formatter)
            var dateE: LocalDate = LocalDate.parse("11.11.1111 00:00", formatter)
            var client: Client? = null
            try {
                dateS = LocalDate.parse(dateStart.getText(), formatter)
                dateE = LocalDate.parse(dateEnd.getText(), formatter)
                if(!nameClientField.text.isEmpty())
                    client = Client(nameClientField.getText())
            }catch (e: Exception){
                JOptionPane.showMessageDialog(null,"Ошибка")
            }
            val nullDate = LocalDate.parse("11.11.1111 00:00", formatter)
            if(client == null || dateE == nullDate || dateS == nullDate
                || cityField.text.isEmpty() || dateS > dateE){
                JOptionPane.showMessageDialog(null,"Ошибка")
            }else {
                clientList.addElement(client)
                flightList.addElement(Flight(cityField.getText(), dateS, dateE, client))
                JOptionPane.showMessageDialog(null,"Успешно")
                mainFrame()
            }
        }
    }
}

class TrainButton : ActionListener {
    override fun actionPerformed(e: ActionEvent) {
        //Удаление компонентов на панели
        contentPanel.removeAll()
        buttonPanel.removeAll()

        //Создание новых
        val nameClientField = JTextField(30)
        val nameClientInfo = JLabel(":Имя Клиента")

        val cityField = JTextField(30)
        val cityInfo = JLabel(":Город")

        val dateStartInfo = JLabel(":Дата отъезда")
        val dateStart = JTextField(30)

        val dateEndInfo = JLabel(":Дата Приезда")
        val dateEnd = JTextField(30)

        val book = JButton("Бронировать")
        val cancel = JButton("Отмена")




        //Занесение в панели
        contentPanel.layout = FlowLayout(FlowLayout.LEFT)
        contentPanel.add(nameClientField)
        contentPanel.add(nameClientInfo)

        contentPanel.add(cityField)
        contentPanel.add(cityInfo)
        contentPanel.add(dateStart)
        contentPanel.add(dateStartInfo)
        contentPanel.add(dateEnd)
        contentPanel.add(dateEndInfo)

        buttonPanel.add(book)
        buttonPanel.add(cancel)

        contentPanel.updateUI()
        buttonPanel.updateUI()

        //Дейтсвия на кнопки
        cancel.addActionListener(CancelButton())
        book.addActionListener {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            var dateS: LocalDate = LocalDate.parse("11.11.1111 00:00", formatter)
            var dateE: LocalDate = LocalDate.parse("11.11.1111 00:00", formatter)
            var client: Client? = null
            try {
                dateS = LocalDate.parse(dateStart.getText(), formatter)
                dateE = LocalDate.parse(dateEnd.getText(), formatter)
                if(!nameClientField.text.isEmpty())
                    client = Client(nameClientField.getText())
            }catch (e: Exception){
                JOptionPane.showMessageDialog(null,"Ошибка")
            }
            val nullDate = LocalDate.of(1111, 11, 11)
            if(client == null || dateE == nullDate || dateS == nullDate
                || cityField.text.isEmpty() || dateS > dateE){
                JOptionPane.showMessageDialog(null,"Ошибка")
            }else {
                clientList.addElement(client)
                trainList.addElement(Train(cityField.getText(), dateS, dateE, client))
                JOptionPane.showMessageDialog(null,"Успешно")
                mainFrame()
            }
        }
    }
}


class ClientTableModel(private val clients: DefaultListModel<Client>) : AbstractTableModel() {

    override fun getRowCount() = clients.size

    override fun getColumnCount() = 5 //количество столбцов

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any {
        return when (columnIndex) {
            0 -> clients[rowIndex].name
            1 -> {
                var i = 0
                while (i < hotelList.size()){
                    if(hotelList[i].find(clients[rowIndex]).equals("+")){
                        return "Отель"
                    }else
                        i++
                }
                i = 0
                while (i < flightList.size()){
                    if(flightList[i].find(clients[rowIndex]).equals("+")){
                        return "Самолет"
                    }else
                        i++
                }
                i = 0
                while (i < trainList.size()){
                    if(trainList[i].find(clients[rowIndex]).equals("+")){
                        return "Поезд"
                    }else
                        i++
                }
            }
            2 ->{
                    var i = 0
                    while (i < hotelList.size()){
                        if(hotelList[i].find(clients[rowIndex]).equals("+")){
                            return hotelList[i].get(clients[rowIndex])[0]!!.toString()
                        }else
                            i++
                    }
                    i = 0
                    while (i < flightList.size()){
                        if(flightList[i].find(clients[rowIndex]).equals("+")){
                            return flightList[i].get(clients[rowIndex])[0]!!.toString()
                        }else
                            i++
                    }
                    i = 0
                    while (i < trainList.size()){
                        if(trainList[i].find(clients[rowIndex]).equals("+")){
                            return trainList[i].get(clients[rowIndex])[0]!!.toString()
                        }else
                            i++
                    }
            }
            3 ->{
                    var k = 0
                    while (k < hotelList.size()){
                        if(hotelList[k].find(clients[rowIndex]).equals("+")){
                            return hotelList[k].get(clients[rowIndex])[1]!!.toString()
                        }else
                            k++
                    }
                    k = 0
                    while (k < flightList.size()){
                        if(flightList[k].find(clients[rowIndex]).equals("+")){
                            return flightList[k].get(clients[rowIndex])[1]!!.toString()
                        }else
                            k++
                    }
                    k = 0
                    while (k < trainList.size()){
                        if(trainList[k].find(clients[rowIndex]).equals("+")){
                            return trainList[k].get(clients[rowIndex])[1]!!.toString()
                        }else
                            k++
                    }
            }
            4 ->{
                    var q = 0
                    while (q < hotelList.size()){
                        if(hotelList[q].find(clients[rowIndex]).equals("+")){
                            return hotelList[q].get(clients[rowIndex])[2]!!.toString()
                        }else
                            q++
                    }
                    q = 0
                    while (q < flightList.size()){
                        if(flightList[q].find(clients[rowIndex]).equals("+")){
                            return flightList[q].get(clients[rowIndex])[2].toString()
                        }else
                            q++
                    }
                    q = 0
                    while (q < trainList.size()){
                        if(trainList[q].find(clients[rowIndex]).equals("+")){
                            return trainList[q].get(clients[rowIndex])[2]!!.toString()
                        }else
                            q++
                    }
                }
            else -> throw IllegalArgumentException("Invalid column index")
        }
    }

    override fun getColumnName(column: Int): String {
        return when (column) {
            0 -> "ФИО"
            1 -> "Бронирование"
            2 -> "Название"
            3 -> "Дата начала"
            4 -> "Дата конца"
            else -> throw IllegalArgumentException("Invalid column index")
        }
    }
}


class ClientListButton : ActionListener {
    override fun actionPerformed(e: ActionEvent) {
        contentPanel.removeAll()
        var clientTable: JTable? = null
        var scrollPane: JScrollPane? = null
        if (!clientList.isEmpty) {
            clientTable = JTable(ClientTableModel(clientList))
            scrollPane = JScrollPane(clientTable)
            contentPanel.add(scrollPane, BorderLayout.CENTER)
        } else {
            val emptyTable = JTable(1, 1)
            emptyTable.setValueAt("Бронирования не было", 0, 0)
            val scrollPane = JScrollPane(emptyTable)
            contentPanel.add(scrollPane, BorderLayout.CENTER)
        }
        contentPanel.updateUI()


        buttonPanel.removeAll()
        val delete = JButton("Удалить")
        val cancel = JButton("Назад")
        buttonPanel.add(delete)
        buttonPanel.add(cancel)
        buttonPanel.updateUI()
        cancel.addActionListener(CancelButton())
        buttonPanel.updateUI()
        contentPanel.updateUI()
        delete.addActionListener {
            val selectionModel = clientTable?.selectionModel
            if (selectionModel != null && selectionModel.isSelectionEmpty) {
                JOptionPane.showMessageDialog(null,"Ошибка, выделите строку")
            }
            else {
                val index = clientTable?.selectedRow
                if (index != null) {
                    clientList.remove(index)
                }
                clientTable?.updateUI()
                scrollPane?.updateUI()
                contentPanel.updateUI()
                buttonPanel.updateUI()
            }


        }

    }
}





fun mainFrame(){
    contentPanel.removeAll()
    buttonPanel.removeAll()
    contentPanel.updateUI()
    buttonPanel.updateUI()


    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(605, 500)

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

    // Устанавливаем менеджер компоновки для frame
    frame.layout = BorderLayout()

    // Добавляем панель для контента в левую часть окна
    frame.add(contentPanel, BorderLayout.WEST)

    // Добавляем панель для кнопок в правую часть окна
    frame.add(buttonPanel, BorderLayout.EAST)

    // Устанавливаем размеры панели для контента
    contentPanel.preferredSize = Dimension(480, 500)


    buttonPanel.preferredSize = Dimension(125,500)

    // Добавляем компоненты на панели
    contentPanel.add(imageLabel)
    buttonPanel.add(clients)
    buttonPanel.add(hotel)
    buttonPanel.add(flight)
    buttonPanel.add(train)

    // Отображаем окно
    frame.isVisible = true


    hotel.addActionListener(HotelButton())
    clients.addActionListener(ClientListButton())
    flight.addActionListener(FlightButton())
    train.addActionListener(TrainButton())

}

import java.time.LocalDate
import javax.swing.DefaultListModel

interface Booking {
    fun book(client: Client, startDate: LocalDate, endDate: LocalDate)
    fun get(client: Client): Array<String>
    fun find(client: Client): String
}

import java.time.LocalDate

class Hotel(destination: String, startDate: LocalDate, endDate: LocalDate, client: Client?) : Travel(destination, startDate, endDate, client) {
    override fun book(client: Client, startDate: LocalDate, endDate: LocalDate) {
        super.book(client, startDate, endDate)
        println("Hotel booked for ${destination} from $startDate to $endDate.")
    }



    override fun get(client: Client): Array<String> {
        return super.get(client)
    }

    override fun find(client: Client): String {
        return super.find(client)
    }
}

class Flight(destination: String, startDate: LocalDate, endDate: LocalDate, client: Client?) : Travel(destination, startDate, endDate, client) {
    override fun book(client: Client, startDate: LocalDate, endDate: LocalDate) {
        super.book(client, startDate, endDate)
        println("Flight booked to ${destination} from $startDate to $endDate.")
    }



    override fun get(client: Client): Array<String> {
        val info: Array<String> = arrayOf(this.destination, this.startDate!!.toString(), this.endDate!!.toString())
        return info
    }

    override fun find(client: Client): String {
        return super.find(client)
    }
}

class Train(destination: String, startDate: LocalDate, endDate: LocalDate, client: Client?) : Travel(destination, startDate, endDate, client) {
    override fun book(client: Client, startDate: LocalDate, endDate: LocalDate) {
        super.book(client, startDate, endDate)
        println("Train booked to ${destination} from $startDate to $endDate.")
    }


    override fun get(client: Client): Array<String> {
        return super.get(client)
    }

    override fun find(client: Client): String {
        return super.find(client)
    }
}


class Client(val name: String)


import java.time.LocalDate
import javax.swing.DefaultListModel

abstract class Travel(val destination: String, var startDate: LocalDate, var endDate: LocalDate, var client: Client?) : Booking {

    override fun book(client: Client, startDate: LocalDate, endDate: LocalDate) {
        this.client = client
        this.startDate = startDate
        this.endDate = endDate
        println("Booking for ${client.name} confirmed from $startDate to $endDate.")
    }


    override fun get(client: Client): Array<String> {
        var info: Array<String> = arrayOf()
        if (this.client == client) {
            info = arrayOf(this.destination, this.startDate!!.toString(), this.endDate!!.toString())
        } else {
            println("Booking not found for ${client.name}.")
        }
        return info
    }

    override fun find(client: Client): String {
        var final = ""
        if (this.client == client) {
            final = "+"
        } else {
            final = "-"
        }
        return final
    }
}
