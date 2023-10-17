import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class TodoListApp extends JFrame {
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public TodoListApp() {
        super("TodoListApp");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(450, 150, 450, 300);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas", "Excluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);

        // TRATAMENTO EVENTOS

        // Adiciona um WindowListener para lidar com o fechamento da janela
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                windowClosingHandler(e);
            }
        });

        // Evento do Botão de adicionar pelo botão e pelo teclado
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        // Adiciona um KeyListener para o campo de entrada
        taskInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }
        });

        // Evento do botão de Excluir com o delete e o botão da interface
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        // Adiciona um KeyListener para o campo de entrada
        taskList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteTask();
                }
            }
        });

        // Exclui a tarefa arrastando ao botão de Excluir
        taskList.setDragEnabled(true);
        taskList.setTransferHandler(new TaskTransferHandler());

        deleteButton.setDropTarget(new DropTarget() {
            @Override
            public void drop(DropTargetDropEvent e) {
                try {
                    Transferable tr = e.getTransferable();
                    if (tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                        e.acceptDrop(DnDConstants.ACTION_MOVE);
                        String draggedIndex = (String) tr.getTransferData(DataFlavor.stringFlavor);
                        int sourceIndex = Integer.parseInt(draggedIndex);
                        if (sourceIndex >= 0 && sourceIndex < tasks.size()) {
                            // Confirmação com JOptionPane
                            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta tarefa?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);

                            if (resposta == JOptionPane.YES_OPTION) {
                                Task task = tasks.remove(sourceIndex);
                                updateTaskList();
                            }
                        }
                        e.dropComplete(true);
                        return;
                    }
                    e.rejectDrop();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    e.rejectDrop();
                }
            }
        });

        markDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });
        // Adiciona um KeyListener para a lista de tarefas
    taskList.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) { 
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                markTaskDone();
            }
        }
});

 

    }
    
    //METODO ADICIONAR
    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }

    }

    //METODO EXCLUIR
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esta tarefa?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                tasks.remove(selectedIndex);
                updateTaskList();
            }
        }
    }
//METODO EXCLUIR VIA DRAG AND DROP
class TaskTransferHandler extends TransferHandler {
    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        JList<String> list = (JList<String>) c;
        int index = list.getSelectedIndex();
        return new StringSelection(Integer.toString(index));
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport info) {
        return info.isDataFlavorSupported(DataFlavor.stringFlavor);
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport info) {
        if (!canImport(info)) {
            return false;
        }

        JList.DropLocation dl = (JList.DropLocation) info.getDropLocation();
        int index = dl.getIndex();

        try {
            String draggedIndex = (String) info.getTransferable().getTransferData(DataFlavor.stringFlavor);
            int sourceIndex = Integer.parseInt(draggedIndex);

            if (index == -1) {
                // Não foi solto sobre um item, portanto não faz nada
                return false;
            }

            if (index >= 0 && index < tasks.size() && sourceIndex >= 0 && sourceIndex < tasks.size() && index != sourceIndex) {
                // Confirmação com JOptionPane
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta tarefa?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    // Remove a tarefa arrastada
                    deleteTask();
                    updateTaskList();
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}




    

    //METODO MARCAR COMO CONCLUIDO
    private void markTaskDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    //METODO FILTRAR
    private void filterTasks() {
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone())
                    || (filter.equals("Concluídas") && task.isDone())
                    || (filter.equals("Excluídas ") && task.isRemoved())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    //METODO LIMPAR TODAS AS TAREFAS
    private void clearCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    //METODO FECHAR JANELA
    private void windowClosingHandler(WindowEvent e) {
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente parar o programa?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            // Fecha a janela corretamente apenas se o usuário selecionar "Sim"
            this.dispose();
        } else {
            // Caso o usuário escolha "Não", cancele o fechamento da janela
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }

        // Adiciona um WindowListener para lidar com o fechamento da janela
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                windowClosingHandler(e);
            }
        });
    }

    //METODO ATUALIZAR TAREFAS
    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
        }
    }

    public void run() {
        this.setVisible(true);
    }
}