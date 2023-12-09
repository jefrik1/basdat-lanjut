package org.example;

import java.util.List;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("1. Tambah Task");
            System.out.println("2. Tampilkan Task");
            System.out.println("3. Update Task");
            System.out.println("4. Hapus Task");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan deskripsi task: ");
                    scanner.nextLine(); // consume newline
                    String deskripsi = scanner.nextLine();
                    Task newTask = new Task();
                    newTask.setDeskripsi(deskripsi);
                    newTask.setSelesai(false);
                    taskManager.addTask(newTask);
                    System.out.println("Task ditambahkan!");
                    break;
                case 2:
                    List<Task> tasks = taskManager.getAllTasks();
                    for (Task task : tasks) {
                        System.out.println("ID: " + task.getId());
                        System.out.println("Deskripsi: " + task.getDeskripsi() + ", Selesai: " + task.isSelesai() + "\n");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan ID task yang akan diupdate: ");
                    String taskId = scanner.next();
                    Task taskToUpdate = new Task();
                    taskToUpdate.setId(taskId);
                    System.out.print("Masukkan deskripsi baru: ");
                    scanner.nextLine(); // consume newline
                    taskToUpdate.setDeskripsi(scanner.nextLine());
                    System.out.print("Apakah task sudah selesai? (true/false): ");
                    taskToUpdate.setSelesai(scanner.nextBoolean());
                    taskManager.updateTask(taskToUpdate);
                    System.out.println("Task diupdate!");
                    break;
                case 4:
                    System.out.print("Masukkan ID task yang akan dihapus: ");
                    String taskIdToDelete = scanner.next();
                    taskManager.deleteTask(taskIdToDelete);
                    System.out.println("Task dihapus!");
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi.");
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }
    }
}

